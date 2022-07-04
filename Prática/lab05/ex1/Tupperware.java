package ex1;

public class Tupperware extends Container {
    private static Portion portion;
    public Tupperware(Portion p) {
        portion = p;
    }
    public static boolean removePortion() {
        portion = null;
        return true;
    }
    public static boolean isEmpty() {
        return portion == null;
    }
    public Portion getPortion() {
        if (isEmpty()) {
            return null;
        } else {
            return portion;
        }
    }
    public String toString() {
        return "Tupperware with portion = " + portion;
    }
}