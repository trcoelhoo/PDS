package ex1;

public class PlasticBag extends Container {
    private static Portion portion;
    public PlasticBag(Portion p) {
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
        return "PlasticBag with portion = " + portion;
    }
}
