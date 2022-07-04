package ex2;

public class LemonCakeBuilder extends CakeBuilderAbs {
    public  void addCreamLayer(){
        cake.setMidLayerCream(Cream.Lemon);
    }
    public  void addTopLayer(){
        cake.setTopLayerCream(Cream.Whipped_cream);
    }
    public  void addTopping(){
        cake.setTopping(Topping.Chocolate);
    }
    public  void addCakeLayer(){
        cake.setCakeLayer(" Lemon ");
        cake.setNumCakeLayers(1+cake.getNumCakeLayers());
    }
}
