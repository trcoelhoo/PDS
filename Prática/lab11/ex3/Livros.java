package ex3;

public class Livros{
    private String titulo, autor, Isbn;
    private int ano;

    private State s;



    public Livros(String titulo, String autor, String Isbn, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.Isbn = Isbn;
        this.ano = ano;
        this.s = new Inventario ();
    }

    public String getTitulo() {
        return this.titulo;
    }
    public String getIsbn() {
        return this.Isbn;
    }

    public String getAutor() {
        return this.autor;
    }
   
    public State getS() {
        return this.s;
    }

    public int getAno() {
        return this.ano;
    }


    public void setState(State s){
        this.s=s;
    }

    public boolean registar(){
        return s.registar(this);
        
    }
    public boolean devolve(){
        return s.devolve(this);
    }
    public boolean cancelaReserva(){
        return s.cancelaReserva(this);
    }
    public boolean take(){
        return s.take(this);
    }
    public boolean reserva(){
        return s.reserva(this);
    }


    @Override
    public String toString() {
        return getTitulo() + "\t" +getAutor()+ "\t[" + getS()+"]";
    }

}
