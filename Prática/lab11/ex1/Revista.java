package ex1;

public class Revista {
    private Strategy strategy;
    private SmartPhone[] array;

    public Revista(Strategy strategy, SmartPhone[] array) {
        this.strategy = strategy;
        this.array = array;
    }

    public void sort(Strategy s, String set) {
        strategy = s;
        strategy.sort(array, set);
    }

    
    
}
