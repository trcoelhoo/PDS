package ex1;

public class Manager extends Decorator {
    public Manager(Competencias competencia) {
        super(competencia);
    }

    @Override
    public void work() {
        super.work();
        manage();
        System.out.println("Manager is working");
    }
    @Override
    public void start(Date date) {
        super.start(date);
        System.out.println("Manager started working on " + date);
    }
    @Override
    public void terminate(Date date) {
        super.terminate(date);
        System.out.println("Manager finished working on " + date);
    }

    public void manage(){
        System.out.println("Manager manage");
    }
    
}
