package ex1;

public class SmartPhone {
    
    String nome;
	String processador;
	Double preco;
	int memoria;
	String camara; 

    public SmartPhone(String nome, String processador, Double preco, int memoria, String camara) {
        this.nome = nome;
        this.processador = processador;
        this.preco = preco;
        this.memoria = memoria;
        this.camara = camara;
    }

    public String getNome() {
        return nome;
    }

    public String getProcessador() {
        return processador;
    }

    public Double getPreco() {
        return preco;
    }

    public int getMemoria() {
        return memoria;
    }

    public String getCamara() {
        return camara;
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "nome='" + nome + '\'' +
                ", processador='" + processador + '\'' +
                ", preco=" + preco +
                ", memoria=" + memoria +
                ", camara='" + camara + '\'' +
                '}';
    }


}
