package ex2;

public class Cartao {
    private int numero=0;
    private Employee empregado;

    public Cartao(Employee empregado) {
        this.empregado = empregado;
        this.numero = 1000000*numero++;
    }

    public int getNumero() {
        return numero;
    }

    public Employee getEmpregado() {
        return empregado;
    }

    @Override
    public String toString() {
        return "Cartao{" + "numero=" + numero + ", empregado=" + empregado + '}';
    }
    
    
}
