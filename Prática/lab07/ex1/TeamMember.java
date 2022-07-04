package ex1;

public class TeamMember extends Decorator {
    public TeamMember(Competencias competencia) {
        super(competencia);
    }

    @Override
    public void work() {
        super.work();
        colaborate();
        System.out.println("TeamMember is working");
    }

    @Override
    public void start(Date date) {
        super.start(date);
        System.out.println("TeamMember started working on " + date);
    }

    @Override
    public void terminate(Date date) {
        super.terminate(date);
        System.out.println("TeamMember finished working on " + date);
    }


    public void colaborate(){
        System.out.println("TeamMember colaborate");
    }
    
    
}
