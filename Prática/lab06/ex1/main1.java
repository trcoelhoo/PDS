package ex1;

import java.util.List;


public class main1 { 
        
    public static void main(String[] args) {
        Employee e1 = new Employee("Tiago", 98385, 1150);
        Employee e2 = new Employee("Joao", 98000, 1000);
        Database db = new Database();
        db.addEmployee(e1);
        db.addEmployee(e2);
        Employee employees[] = db.getAllEmployees();
        System.out.println("Db antes de remover: ");
        for (Employee e : employees){
            System.out.println(" Nome: "+e.getName()+ ", Numero: " + e.getEmpNum() + ", Salario: " + e.getSalary());
        }
        System.out.println("");

        db.deleteEmployee(e1.getEmpNum());
        employees = db.getAllEmployees();
        System.out.println("Db depois de remover: ");
        for (Employee e : employees){
            System.out.print(" Nome: "+e.getName()+ ", Numero: " + e.getEmpNum() + ", Salario: " + e.getSalary());
        }
        System.out.println("");


        /*______________________________Registo______________________________*/ 

        Empregado emp1 = new Empregado("Vitor", "Ferreira", 98188, 2000);
        Empregado emp2 = new Empregado("Filipa", "Alves", 97181, 1500);
        Registos r  = new Registos();
        r.insere(emp1);
        r.insere(emp2);
        List <Empregado> empregados = r.listaDeEmpregados();
        System.out.println("");
        System.out.println("Registo antes de remover: ");
        for (Empregado e : empregados){
            System.out.println(" Nome: " + e.nome() + ", Apelido: " + e.apelido() + ", code: " + e.codigo() + ", salario: " + e.salario());
        }
        System.out.println("");

        if (r.isEmpregado(emp1.codigo())){
            r.remove(emp1.codigo());
        }
        System.out.println("Registo depois de remover: ");
        empregados = r.listaDeEmpregados();
        for (Empregado e : empregados){
            System.out.print("Nome: " + e.nome() + ", Apelido: " + e.apelido() + ", code: " + e.codigo() + ", salario: " + e.salario());
        }
        System.out.println("");
    }
}
