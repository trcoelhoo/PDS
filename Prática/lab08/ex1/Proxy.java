package ex1;

public class Proxy implements BankAccount {
    
    
    private BankAccount bankAccount;

    public Proxy(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void deposit(double amount) {
        bankAccount.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if (Company.user==User.OWNER){
            return bankAccount.withdraw(amount);
        }
        return false;
    }

    @Override
    public double balance() {
        if (Company.user==User.OWNER){
            return bankAccount.balance();
        }
        System.out.println("You are not authorized to see this information");
        return 0;
    }   
}
