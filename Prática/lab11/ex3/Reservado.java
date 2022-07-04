package ex3;

public class Reservado implements State{

    @Override
    public boolean registar(Livros l) {
        System.err.println("Operação não disponível");
        return false;
        
    }

    @Override
    public boolean devolve(Livros l) {
        System.err.println("Operação não disponível");
        return false;
        
    }

    @Override
    public boolean cancelaReserva(Livros l) {
        l.setState(new Disponivel());
        return true;
        
    }

    @Override
    public boolean take(Livros l) {
        
        System.err.println("Operação não disponível");
        return false;
        
    }

    @Override
    public boolean reserva(Livros l) {
        System.err.println("Operação não disponível");
        return false;
        
    }

    @Override
    public String toString() {
        return "Reservado";
    }
    
}