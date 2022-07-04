package ex2;

public abstract class CakeBuilderAbs implements CakeBuilder {
    protected Cake cake;

    public Cake getCake(){
        return cake;
    }
    public void createCake(){
        cake = new Cake();
    }

    public void setCakeShape(Shape shape){
        cake.setShape(shape);
    }
   
    public  void addCakeLayer(){
        cake.setNumCakeLayers(1+cake.getNumCakeLayers());
    }
    public void addMessage(String m){
        cake.setMessage(m);
    }
    public abstract void addCreamLayer();
    public abstract void addTopLayer();
    public abstract void addTopping();
}
