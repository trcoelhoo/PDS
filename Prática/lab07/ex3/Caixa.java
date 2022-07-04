package ex3;
import java.util.*;
public class Caixa extends Alimentos{
    private String nome;
    private double peso;
    private double pesoTotal;
    private ArrayList<Alimentos> box;

    public Caixa (String nome,double peso){
        this.nome = nome;
        this.peso = peso;
        this.pesoTotal = peso;
        this.box = new ArrayList<>();
    }
    @Override
    public String getNome()
    {
        return this.nome ;
    }

    @Override
    public double getPesoTotal()
    {
        return this.pesoTotal ;
    }

    
    public double getPeso()
    {
        return this.peso;
    }

    public double totalCaixa(){
        this.pesoTotal=this.peso;
        for (Alimentos i : this.box){
            this.pesoTotal+=i.getPesoTotal();
        }
        return this.pesoTotal;
    }

    @Override
    public void draw()
    {
        System.out.println(id+"* Caixa '"+this.getNome()+ "' [ Weight:"+this.getPeso()+ "; Total:"+this.totalCaixa()+ " ]");
        id.append("   ");
        for (Alimentos i : this.box){
            i.draw();
        }
        id.setLength(id.length()-3);
    }

    public void add (Alimentos al){
        this.box.add(al);
        this.pesoTotal+=al.getPesoTotal();
    }

       
    public List<Alimentos> getBox()
    {
        return this.box ;
    }


}
