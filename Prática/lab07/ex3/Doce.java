package ex3;

public class Doce extends Alimentos {
    private double peso;
    private String nome;

    public Doce(String nome,double peso)
    {
        this.nome = nome;
        this.peso = peso;
    }

    @Override
    public void draw() {
        System.out.println(id.toString()+" Doce "+this.getNome()+ "' "+  " - Weight:"+this.getPesoTotal()+ " ");
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
