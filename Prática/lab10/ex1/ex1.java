package ex1;

public class ex1 {
    public static void main(String[] args) {
        
        Gestor g = new Gestor("Gestor");
        Cliente c1 = new Cliente("Cliente1");
        Cliente c2 = new Cliente("Cliente2");
        Cliente c3 = new Cliente("Cliente3");
        Cliente c4 = new Cliente("Cliente4");

        Produto p1 = new Produto("Produto1", 10, Estado.STOCK, g);
        Produto p2 = new Produto("Produto2", 10, Estado.STOCK, g);
        Produto p3 = new Produto("Produto3", 10, Estado.STOCK, g);
        Produto p4 = new Produto("Produto4", 10, Estado.STOCK, g);
        boolean b=true;
        g.notify(p1);
        g.notify(p2);
        p1.setEstado(Estado.LEILAO);
        
        g.notify(p1);
        g.notify(p2);
        g.notify(p3);
        g.notify(p4);

        c1.licitar(p1, 10);
        c2.licitar(p1, 20);
        c3.licitar(p1, 19);
        c4.licitar(p1, 21);
        int cbid=22;
        boolean p=true;
        while(p1.getTempo()<=10){
            if (b==true) {
               
                p=c1.licitar(p1, cbid++);
                b=false;
            }
            else{
                p= c2.licitar(p1, cbid++);
                b=true;
            }
            if(p==false){
               
                break;
            }
        }
        cbid=22;
        p=true;
        while(p2.getTempo()<=10){
            if (b==true) {
               
                p=c1.licitar(p2, cbid++);
                b=false;
            }
            else{
                p= c2.licitar(p2, cbid++);
                b=true;
            }
            if(p==false){
               
                break;
            }
        }
        
        p3.setEstado(Estado.LEILAO);

        while(p3.getTempo()<=10){
            if (b==true) {
               
                p=c1.licitar(p3, cbid++);
                b=false;
            }
            else{
                p= c2.licitar(p3, cbid++);
                b=true;
            }
            if(p==false){
               
                break;
            }
        }
        
        p4.setEstado(Estado.LEILAO);
        cbid=11;
        p=true;
        while(p4.getTempo()<=10){
            if (b==true) {
               
                p=c1.licitar(p4, cbid++);
                b=false;
            }
            else{
                p= c2.licitar(p4, cbid++);
                b=true;
            }
            if(p==false){
               
                break;
            }
        }



    }

    
}
