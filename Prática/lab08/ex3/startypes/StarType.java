package startypes;
import java.awt.*;

public abstract class StarType {

    private int size;
    private Color color;
    protected String description;
    protected Float[] physicalProperties;
    private int x;
    private int y;
    private StarFactory st ;

    public StarType(int size, Color color, int x, int y) {
        this.size = size;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public StarType(StarFactory st, int x2, int y2) {
        this.st = st;
        this.x = x2;
        this.y = y2;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y , size, size);
    }
    
}
