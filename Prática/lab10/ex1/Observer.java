package ex1;

public abstract class Observer {
    protected Produto p;
    public abstract void update(String message);
    public abstract String getType();
}
