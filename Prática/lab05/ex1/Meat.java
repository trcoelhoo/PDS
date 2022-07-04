package ex1;

public class Meat implements Portion {
    private Temperature temp;
    private State state;

    public Meat(Temperature temp) {
        this.temp = temp;
        this.state = State.Solid;
    }

    public Temperature getTemperature() {
        return temp;
    }

    public String getType() {
        if (temp == Temperature.WARM) {
            return "Pork";
        } else {
            return "Tuna";
        }
    }

    public State getState() {
        return state;
    }
    public String toString() {
        return getType() + ": " + "Temperature " + getTemperature() + ", " + "State " + getState();
    }

}
