package ex2;
public class Cake {
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;
    

    public Shape getShape() {
        return this.shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public String getCakeLayer() {
        return this.cakeLayer;
    }

    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public int getNumCakeLayers() {
        return this.numCakeLayers;
    }

    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }

    public Cream getMidLayerCream() {
        return this.midLayerCream;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        if (this.numCakeLayers >1)
            this.midLayerCream = midLayerCream;
    }

    public Cream getTopLayerCream() {
        return this.topLayerCream;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public Topping getTopping() {
        return this.topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        
        String print= this.cakeLayer+ " cake with "+ this.numCakeLayers+ " layers ";
        if (this.midLayerCream != null){
            print +=" and "+ this.midLayerCream.getCustomString()+ " cream, ";
        }
        else{
            print+= " ,";
        }
        print+=" topped with "+ this.topLayerCream.getCustomString() + " and " + this.topping.getCustomString()+ " . Message says : \""+ this.message+ "\"" ;
        return print;
    }

}