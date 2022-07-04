package ex3;

public class Disponivel implements State{

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
        System.err.println("Operação não disponível");
        return false;
        
    }

    @Override
    public boolean take(Livros l) {
        l.setState(new Emprestado());
        return true;
        
    }

    @Override
    public boolean reserva(Livros l) {
        l.setState(new Reservado());
        return true;
        
    }

    @Override
    public String toString() {
        return "Disponível";
    }
    
}