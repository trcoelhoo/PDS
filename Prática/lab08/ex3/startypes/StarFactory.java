package startypes;
import java.util.*;
import java.awt.*;
public class StarFactory {
    private Color color;
    private int size;
    private String des;
    public StarFactory(Color color, int size, String des){
        this.color = color;
        this.size = size;
        this.des = des;
    }

    public Color getColor()
    {
        return this.color;
    }

    public int getSize(){
        return this.size;
    }

    public String getDes()
    {
        return this.des;
    }

    
}
