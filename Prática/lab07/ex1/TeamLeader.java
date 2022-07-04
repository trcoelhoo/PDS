package ex1;

public class TeamLeader extends Decorator {
    public TeamLeader(Competencias competencia) {
        super(competencia);
    }

    @Override
    public void work() {
        super.work();
        plan();
        System.out.println("TeamLeader is working");
    }

    @Override
    public void start(Date date) {
        super.start(date);
        System.out.println("TeamLeader started working on " + date);
    }

    @Override
    public void terminate(Date date) {
        super.terminate(date);
        System.out.println("TeamLeader finished working on " + date);
    }

    public void plan(){
        System.out.println("TeamLeader plan");
    }

}