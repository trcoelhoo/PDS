package ex3;
public class Bebida extends Alimentos {
    private double peso;
    private String nome;

    public Bebida(String nome,double peso)
    {
        this.nome = nome;
        this.peso = peso;
    }

    @Override
    public void draw() {
        System.out.println(id.toString()+" Bebida '"+this.getNome()+ "' "+  " - Weight:"+this.getPesoTotal()+ " ");
    }

    @Override
    public double getPesoTotal() {
        return this.peso;
    }

    @Override
    public String getNome() {
        return this.nome;
    }



}