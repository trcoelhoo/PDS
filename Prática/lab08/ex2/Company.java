package ex2;
import java.util.*;
class Company {

public static User user;
private List<Employee> emps = new ArrayList<>();
private Parking park = new Parking();
private Insurance ins = new Insurance();
private SocialSecurity s = new SocialSecurity();
private List<Cartao> cartoes = new ArrayList<>();


	
	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount();
			ba.deposit(e.getSalary());
		}
	}
	
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}

	public void admitEmployee(Person p, double salary) {
		Employee e = new Employee(p, salary);
		emps.add(e);
		this.cartoes.add(new Cartao(e));
		this.ins.regist(p);
		this.s.regist(p);
		if(e.getSalary()> getMediaSalary() ){
			this.park.allow(p);
		}

	}

	public int getMediaSalary() {
		int sum = 0;
		for (Employee e : emps) {
			sum += e.getSalary();
		}
		return sum / emps.size();
	}

	public void parkAllowed(Employee e){
		if(this.park.isallowed(e.getPerson())){
			System.out.println("Allowed to parking");
		}
		else{
			System.out.println("Not allowed to parking");
		}

	}

	public void isRegistedInsurance(Person p){
		if(this.ins.isRegisted(p)){
			System.out.println("Registed Insurance");
		}
		else{
			System.out.println("Not registed Insurance");
		}

	}

	public void isRegistedSocialSecurity(Person p){
		if(this.s.isRegisted(p)){
			System.out.println("Registed Social Security");
		}
		else{
			System.out.println("Not registed Social Security");
		}

	}
}