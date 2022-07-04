package ex3;

public class Conserva extends Alimentos{
    private double peso;
    private String nome;



    public Conserva(String nome,double peso) {
        this.peso = peso;
        this.nome = nome;
    }


    @Override 
    public String getNome()
    {
        return this.nome;
    }
    
    @Override
    public double getPesoTotal()
    {
        return this.peso;
    }
    @Override
    public void draw() {
        
        System.out.println(id.toString()+" Conserva '"+this.getNome()+ "' "+  " - Weight:"+this.getPesoTotal()+ " ");
    }
}
