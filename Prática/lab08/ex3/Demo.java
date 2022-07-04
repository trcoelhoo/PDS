import java.awt.Color;

import startypes.*;

public class Demo {
    static int CANVAS_SIZE = 1200;
    static int STARS_TO_DRAW = 1000000;
    static StarFactory ot = new StarFactory(new Color(225, 250, 250), 5, "This is a long description of the O type star...."); 
    static StarFactory bt  = new StarFactory(new Color(230, 252, 252), 5, "This is a long description of the B type star....");
    static StarFactory gt  = new StarFactory(new Color(245, 250, 250), 1, "This is a long description of the G type star....");
    static StarFactory at = new StarFactory(Color.WHITE, 2, "This is a long description of the A type star....");
    static StarFactory kt  = new StarFactory(new Color(230, 160, 10), 1, "This is a long description of the K type star....");
    static StarFactory ft= new StarFactory(new Color(255, 255, 245), 2, "This is a long description of the F type star....");
    static StarFactory mt  = new StarFactory(Color.RED, 1, "This is a long description of the M type star...."); 
    
    public static void main(String[] args) {
        Sky sky = new Sky();

        // https://astrobackyard.com/wp-content/uploads/2020/03/types-of-stars.jpg
        char[] starTypes = {'O', 'B', 'A', 'F', 'G', 'K', 'M'};
        char type;

		Runtime runtime = Runtime.getRuntime();
		long before = runtime.totalMemory() - runtime.freeMemory();

        for (int i = 0; i < STARS_TO_DRAW; i++) {
            type = starTypes[random(0, starTypes.length-1)];
            sky.placeStar(createStar(type));
        }
        sky.setSize(CANVAS_SIZE, CANVAS_SIZE);
        sky.setBackground(Color.BLACK);
        sky.setVisible(true);

        long after = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory: " + (after - before) / 1024 / 1024 + " MB");

    }

    private static StarType createStar(char type) {
        int x = random(0, CANVAS_SIZE);
        int y = random(0, CANVAS_SIZE);
        StarType star=null;
        switch (type) {
        case 'O' : star = new OStar(ot,x, y); break;
        case 'A' : star = new AStar(at,x, y); break;
        case 'B' : star = new BStar(bt,x, y); break;
        case 'F' : star = new FStar(ft,x, y); break;
        case 'G' : star = new GStar(gt,x, y); break;
        case 'K' : star = new KStar(kt,x, y); break;
        case 'M' : star = new MStar(mt,x, y); break;
        }
        return star;
    }

	private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}