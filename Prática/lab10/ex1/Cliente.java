package ex1;

public class Cliente extends Observer {
    
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    
    public void update(String message) {
        System.out.println("[CLIENTE]: "+message);
    }

    
    public String getType() {
        return "Cliente";
    }

    public String getNome() {
        return nome;
    }

    public boolean licitar(Produto produto, double bid) {
        if (produto.getEstado() == Estado.LEILAO) {
            return produto.licitar(bid);
        }
        else{
            System.out.println("Produto não está em leilão");
            return false;
        }
    }
}
