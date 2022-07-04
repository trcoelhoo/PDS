package ex1;
import java.util.*;

public class Database {
    private Vector<Employee> employees; // Stores the employees

    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
    // Code to add employee
        
        if (!employees.contains(employee)){
            employees.add(employee);
            return true;
        }
        return false;
        
        
    }

    public void deleteEmployee(long emp_num) {
    // Code to delete employee
        for (Employee employee : employees){
            if (employee.getEmpNum() == emp_num){
                employees.remove(employee);
            }
        }
    }

    public Employee[] getAllEmployees() {
    // Code to retrieve collection
        Employee [] retrieved = new Employee [employees.size()];
        for (int i = 0; i< employees.size(); i++){
            retrieved[i] = employees.get(i);
        }
        return retrieved;
    }
}