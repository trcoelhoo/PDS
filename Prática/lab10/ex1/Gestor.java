package ex1;
import java.util.*;
import java.time.Duration;
import java.time.Instant;



public class Gestor extends Observer{
    private String nome;
    private List<Produto> produtos_stock, produtos_leilao, produtos_vendidos;

public Gestor(String nome) {
    this.nome = nome;
    this.produtos_stock = new ArrayList<>();
    this.produtos_leilao = new ArrayList<>();
    this.produtos_vendidos = new ArrayList<>();
}

@Override
public void update(String message) {
    System.out.println("[GESTOR]: "+message);        
}


@Override
public String getType() {
    return "Gestor";
}

public void notify(Produto p){
    if(p.getEstado()==Estado.STOCK){
        for (Produto produto : produtos_leilao) {
            if(produto.getId()==p.getId()){
                produtos_leilao.remove(produto);
                produtos_stock.add(produto);
                break;
            }
        }
    }
    else if(p.getEstado()==Estado.LEILAO){
        for (Produto produto : produtos_stock) {
            if(produto.getId()==p.getId()){
                produtos_stock.remove(produto);
                produtos_leilao.add(p);
                break;
            }
        }

    }
    else if(p.getEstado()==Estado.VENDAS){
        for (Produto produto : produtos_leilao) {
            if(produto.getId()==p.getId()){
                produtos_leilao.remove(produto);
                produtos_vendidos.add(produto);
                break;
            }
        }
    }
}

public void novalicitacao(int id, double bid){
    for (Produto produto : produtos_leilao) {
        if(produto.getId()==id){
            System.out.println("Tempo: "+produto.getTempo());
            if(produto.getTempo()>=1){
                System.out.println("Tempo: "+produto.getTempo());
                if(produto.getPreco()>bid){
                    produto.setEstado(Estado.VENDAS);
                    String s="Produto "+produto.getId()+" foi vendido por "+produto.getPreco();
                    update(s);
                }
                else{
                    produto.setEstado(Estado.STOCK);
                    String s="Produto "+produto.getId()+" foi colocado em stock porque não foi licitado";
                    update(s);
                }
            }

        }
    }
}}
