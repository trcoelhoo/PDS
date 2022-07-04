package ex5;
import java.io.IOException;
public class ex5 {
    public static void main(String[] args) throws IOException {
        boolean recursivo = false;
        if (args.length > 0) {
            
        
            if (args[0].equals("-r")) {
                recursivo = true;
                Visitor v = new Visitor(args[1], recursivo);
                System.out.println("Total: " + v.totalMemory());
            }
            else{
                Visitor v = new Visitor(args[0], recursivo);
                System.out.println("Total: " + v.totalMemory());
            }
        }
        else{
            System.out.println("Uso: java ex5 [-r] <caminho>");
        }

        


    }
}
