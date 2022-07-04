package view;

import model.Thermometer;
import model.ThermometerListener;
/**
 * A thermometer that displays on console the number of a digital thermometer.
 */
public class ConsoleDisplay implements ThermometerListener{
        
        protected Thermometer thermometer;
        
        public ConsoleDisplay(Thermometer thermometer) {
            this.thermometer = thermometer;
        }
        
        @Override
        public void temperatureChanged() {
            System.out.println("The temperature is " + thermometer.getTemperature() + " Fahrenheits.");
        }
    
}
