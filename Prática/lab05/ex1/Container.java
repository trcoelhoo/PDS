package ex1;

public class Container {
    public static Container create( Portion p) {
        State state = p.getState();
        Temperature temp = p.getTemperature();
        if (state == State.Liquid) {
            if (temp == Temperature.WARM) {
                return new TermicBottle(p);
            } else {
                return new PlasticBottle(p);
            }  
        } else {
            if (temp == Temperature.WARM) {
                return new Tupperware(p);
            } else {
                return new PlasticBag(p);
            }
        }
                    
    }
}
