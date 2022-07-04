package ex2;

public class SpongeCakeBuilder extends CakeBuilderAbs{
    public  void addCreamLayer(){
        cake.setMidLayerCream(Cream.Red_Berries);
    }
    public  void addTopLayer(){
        cake.setTopLayerCream(Cream.Whipped_cream);
    }
    public  void addTopping(){
        cake.setTopping(Topping.Fruit);
    }
    public  void addCakeLayer(){
        cake.setCakeLayer(" Sponge ");
        cake.setNumCakeLayers(1+cake.getNumCakeLayers());
    }
}
