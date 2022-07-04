package ex3;

import java.util.Scanner;

public class ex2_main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean test = true;

        Library biblioteca = new Library();
        Livros l1 = new Livros("Java Anti-Strees", "Omodionah", "127631-qtyth", 2000);
        Livros l2 = new Livros("A Guerra dos Padrões", "Jorge Omel", "127631-qa7j", 1976);
        Livros l3 = new Livros("A Procura da Luz", "Khumatkli", "fs7631-qa7j", 1906);

        biblioteca.addBook(l1);
        biblioteca.addBook(l2);
        biblioteca.addBook(l3);

        while(true){
            if (test){
                System.out.println("*** Biblioteca ***");
                biblioteca.print();
                System.out.println(">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela");
            }

            String[] op = sc.nextLine().split(",");
            
            Livros tmp = biblioteca.getLivro(Integer.parseInt(op[0]));
            int opc = Integer.parseInt(op[1]);

            switch(opc){
                case 1:
                    test=tmp.registar();
                    break;
                case 2:
                    test=tmp.take();
                    break;
                case 3:
                    test=tmp.devolve();
                    break;
                case 4:
                    test=tmp.reserva();    
                    break;
                case 5:
                    test=tmp.cancelaReserva();
                    break;
                default:
                    System.out.println("Não existe");
                    System.exit(0);
            }
        }
    }
    
    





}