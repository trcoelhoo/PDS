package ex1;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

class Stopwatch1 {

    private final long nanoSecondsPerMillisecond = 1000000;


    private long stopWatchStartTime = 0;
    private long stopWatchStopTime = 0;
    private boolean stopWatchRunning = false;
    private Produto p;


    public void start(Produto p) {
        this.stopWatchStartTime = System.nanoTime();
        this.stopWatchRunning = true;
    }


    public void stop() {
        this.stopWatchStopTime = System.nanoTime();
        this.stopWatchRunning = false;
    }

    public long getElapsedMilliseconds() {
        long elapsedTime;

        if (stopWatchRunning)
            elapsedTime = (System.nanoTime() - stopWatchStartTime);
        else
            elapsedTime = (stopWatchStopTime - stopWatchStartTime);

        return elapsedTime / nanoSecondsPerMillisecond;
    }
}

public class Produto {
    private int id,tempo;
    private static int ids=0;
    private String desc;
    private double preco,bid;
    private Estado estado;
    Instant instantStarted = Instant.now();
    private List<Observer> obs;
    private Gestor gestor;
    private boolean licit=false;
    private Stopwatch1 watch=new Stopwatch1();

    public Produto(String desc, double preco, Estado estado,Gestor gestor) {
        this.tempo = 0;
        this.desc = desc;
        this.preco = preco;
        this.estado = estado;
        this.id = ids++;
        obs = new ArrayList<>();
        obs.add(gestor);
        this.gestor = gestor;

    }
    public Gestor getGestor(){
        return gestor;
    }
    public void notifyObservers(String mensagem) {
        for (Observer o : obs){
            o.update(mensagem);
        }
    }
    public boolean licitar(double bidc){
        
        this.bid=preco;

        if(bidc>bid && watch.getElapsedMilliseconds()<10 && this.estado==Estado.LEILAO){
            licit=true;
            this.bid=bidc;
            this.preco=bidc;
            this.estado=Estado.LEILAO;
            String s="O produto "+this.id+" foi licitado com o preço de "+bidc;
            notifyObservers(s);
            this.gestor.novalicitacao(this.id,bidc);
            return true;
        }
        if ((watch.getElapsedMilliseconds()>=10) && licit==false){
            licit=false;
            this.estado=Estado.STOCK;
            String s="O produto "+this.id+" não foi licitado";
            notifyObservers(s);
            return false;
        }
        if ((watch.getElapsedMilliseconds()>=10) && licit==true){
            licit=false;
            this.estado=Estado.VENDAS;
            String s="O produto "+this.id+" foi vendido com o preço de "+bid;
            bid=0;
            notifyObservers(s);
            return false;
        }
        else{
            String s="O produto "+this.id+" não foi licitado porque o " + bid + " não é o maior preço licitado";
            notifyObservers(s);
            return false;
        }
                
    }

    public boolean getLicit(){
        return licit;
    }

    public int getId() {
        return id;
    }

    public int getTempo() {
        return (int) watch.getElapsedMilliseconds();
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }


    public String getDesc() {
        return desc;
    }

    public double getPreco() {
        return preco;
    }

    public Estado getEstado() {

        return estado;
    }

    public void setEstado(Estado estado) {
        if(estado==Estado.LEILAO){
            watch.start(this);
            gestor.notify(this);

        }
        if (estado==Estado.VENDAS){
            watch.stop();
            long elapsedSeconds = watch.getElapsedMilliseconds();
            this.tempo= (int) elapsedSeconds;
            gestor.notify(this);

        }
        this.estado = estado;
    }

    public double getBid() {
        return bid;
    }
}