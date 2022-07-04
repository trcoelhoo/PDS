package ex2;

public class YogurtCakeBuilder extends CakeBuilderAbs{
    public  void addCreamLayer(){
        cake.setMidLayerCream(Cream.Vanilla);
    }
    public  void addTopLayer(){
        cake.setTopLayerCream(Cream.Red_Berries);
    }
    public  void addTopping(){
        cake.setTopping(Topping.Chocolate);
    }

    public  void addCakeLayer(){
        cake.setCakeLayer(" Yogurt ");
        cake.setNumCakeLayers(1+cake.getNumCakeLayers());
    }
}
