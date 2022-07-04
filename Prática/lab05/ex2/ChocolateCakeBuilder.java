package ex2;

public class ChocolateCakeBuilder  extends CakeBuilderAbs{
    @Override
    public void addCreamLayer(){
        cake.setMidLayerCream(Cream.Vanilla);
    }
    @Override
    public void addTopLayer(){
        cake.setTopLayerCream(Cream.Whipped_cream);
    }
    @Override
    public void addTopping(){
        
        cake.setTopping(Topping.Fruit);
    }
    public  void addCakeLayer(){
        cake.setCakeLayer(" Soft chocolate");
        cake.setNumCakeLayers(1+cake.getNumCakeLayers());
    }
}
