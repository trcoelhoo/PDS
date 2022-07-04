package ex1;
public class Beverage implements Portion {
    private Temperature temp;
    private State state;

    public Beverage(Temperature temp) {
        this.temp = temp;
        this.state = State.Liquid;
    }
    public Temperature getTemperature() {
        return temp;
    }
    public String getType() {
        if (temp == Temperature.WARM) {
            return "Milk";
        } else {
            return "FruitJuice";
        }
    }
    public State getState() {
        return state;
    }
    public String toString() {
        if (getType()=="Milk") {
            return getType() + ": " + "Temperature " + getTemperature() + ", " + "State " + getState();
        } else {
            return getType() + ": " + "Orange, " + "Temperature " + getTemperature() + ", " + "State " + getState();
        }
        
    }
}
