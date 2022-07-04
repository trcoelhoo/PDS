package ex1;

public abstract class Decorator implements Competencias {
    protected Competencias competencia;
    protected Date dateIni, dateEnd;

    public Decorator(Competencias competencia) {
        this.competencia = competencia;
    }

    public void start(Date date) {
        this.competencia.start(date);
        this.dateIni=date;
    }

    public void terminate(Date date) {
        this.competencia.terminate(date);
        this.dateEnd=date;
    }

    public void work() {
        this.competencia.work();
    }
}