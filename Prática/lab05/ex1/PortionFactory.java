package ex1;
public class PortionFactory {
    public static Portion create(String type, Temperature temp) {
        if (type.equals("Beverage")) {
            return new Beverage(temp);
        } else if (type.equals("Meat")) {
            return new Meat(temp);
        } else {
            return null;
        }
    }
}
