
public class Car implements Product {
    private String code;
    private String description;
    private double points;

    public Car(String code, String description, double points) {
        this.code = code;
        this.description = description;
        this.points = points;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public double points() {
        return this.points;
    }

    @Override
    public String toString() {
        return "Car [code=" + code + ", description=" + description + ", points=" + points + "]";
    }
    
}
