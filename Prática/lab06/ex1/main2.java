package ex1;

public class main2 {
    public static void main(String[] args) {
        Database db = new Database();
        Adapter adp = new Adapter(db);
        Employee e1 = new Employee("Mariana", 99001, 1100);
        Employee e2 = new Employee("Júlia", 99101, 1300);
        adp.inserir(e1);
        adp.inserir(e2);
        System.out.println("Db antes de remover: ");
        adp.print();
        if (adp.existe(e1.getEmpNum())){
            adp.remover(e1.getEmpNum());
        }
        System.out.println("Db depois de remover: ");
        adp.print();
    }
}
