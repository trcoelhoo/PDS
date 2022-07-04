package ex1;

public class main {
    public static void main(String[] args) {
        Competencias c = new Employee("Rui");
        TeamMember teamMember = new TeamMember(new Employee("Ana"));
        TeamLeader teamLeader_Member = new TeamLeader(new TeamMember(new Employee("Maria")));
        TeamLeader teamLeader_Manager = new TeamLeader(new Manager(new Employee("João")));
        
        c.start(new Date(10, 10, 2010));
        c.work();
        c.terminate(new Date(10, 10, 2010));

        teamMember.start(new Date(10, 10, 2010));
        teamMember.work();
        teamMember.terminate(new Date(9, 10, 2020));
        teamMember.colaborate();

        teamLeader_Member.start(new Date(1, 2, 2005));
        teamLeader_Member.work();
        teamLeader_Member.terminate(new Date(1, 2, 2020));
        teamLeader_Member.plan();

        teamLeader_Manager.start(new Date(1, 2, 2005));
        teamLeader_Manager.work();
        teamLeader_Manager.terminate(new Date(1, 2, 2020));
        teamLeader_Manager.plan();


        
    }

}
