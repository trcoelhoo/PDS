package ex3;

public abstract class Alimentos {
    protected static StringBuffer id = new StringBuffer();
    public abstract void draw();
    public abstract double getPesoTotal();
    public abstract String getNome();
}
