package ex1;

public class Adapter extends Registos{
    private Database db;
    public Adapter(Database db) {
        super();
        this.db = db;
    }

    public void inserir(Employee e1){
        db.addEmployee(e1);
    }

    public void remover(long emp_num){
        db.deleteEmployee(emp_num);
    }

    public boolean existe(long codigo){
        for (Employee employee : db.getAllEmployees()){
            if (employee.getEmpNum() == codigo){
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (Employee e1 : db.getAllEmployees()){
            System.out.println("Name: "+e1.getName()+ ", Number: " + e1.getEmpNum() + ", Salary: " + e1.getSalary());
        }
    }
}