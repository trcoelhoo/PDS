package ex2;
public class CakeMaster {
    private CakeBuilder cakebuilder;

    public void setCakeBuilder(CakeBuilder cake){
        cakebuilder=cake;
    }
    public Cake getCake(){
        return cakebuilder.getCake();
    }
    public void createCake(Shape shape, int camadas,String msg){
        cakebuilder.createCake();
        cakebuilder.setCakeShape(shape);
        for (int i=0; i< camadas ; i++){
            cakebuilder.addCakeLayer();
        }
        cakebuilder.addMessage(msg);
        cakebuilder.addCreamLayer();
        cakebuilder.addTopLayer();
        cakebuilder.addTopping();

    }

    public void createCake(String msg){
        createCake(Shape.Circle,1,msg);
    }
    public void createCake(int camadas,String msg){
        createCake(Shape.Circle,camadas,msg);
    }
    public void createCake(Shape shape,String msg){
        createCake(shape,1,msg);
    }
}
