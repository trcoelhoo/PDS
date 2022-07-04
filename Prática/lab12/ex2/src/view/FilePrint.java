package view;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import model.Thermometer;
import model.ThermometerListener;

public class FilePrint implements ThermometerListener {
    
    protected Thermometer thermometer;
    
    public FilePrint(Thermometer thermometer) {
        this.thermometer = thermometer;
    }
    
    @Override
    public void temperatureChanged() {
        try{
            File file = new File("thermometer.txt");
            if(!file.exists()){
                System.out.println("File does not exist, creating  a new one.");
                file.createNewFile();
                System.out.println("File created successfully.");
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write("The temperature is " + thermometer.getTemperature() + " Fahrenheits.");
            bw.close();

        }
        catch(Exception e){
            System.out.println("Error writing to file");
        }
    }
    
    
}
