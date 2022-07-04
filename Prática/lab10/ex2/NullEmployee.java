package ex2;

public class NullEmployee extends Employee {
    public NullEmployee() {
        this.name = "Null";
    }
    @Override
    public String getName() {
        return name;
    }
    
}
