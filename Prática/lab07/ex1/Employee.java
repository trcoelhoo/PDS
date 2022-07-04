package ex1;

public class Employee implements Competencias {
    private String name;
    protected Competencias competencia;
    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public void start(Date date) {
        System.out.println("Employee " + name + " started working on " + date);
    }
    @Override
    public void terminate(Date date) {
        System.out.println("Employee " + name + " finished working on " + date);
    }
    @Override
    public void work(){
        System.out.println("Employee " + name + " is working");
    }

}
