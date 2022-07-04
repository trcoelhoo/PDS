package ex1;

import java.util.Iterator;
import java.util.ListIterator;

public class Teste {
    
    public static void main(String[] args) {
        VectorGeneric<String> v = new VectorGeneric<String>();
        v.addElem("a");
        v.addElem("b");
        v.addElem("c");
        v.addElem("d");
        v.addElem("e");
        v.addElem("f");
        v.addElem("g");
        v.addElem("h");
        v.addElem("i");
        v.addElem("j");
        v.addElem("k");
        v.addElem("l");
        v.addElem("m");
        v.addElem("n");
        v.addElem("o");
        v.addElem("p");
        v.addElem("q");
        v.addElem("r");
        v.addElem("s");
        v.addElem("t");
        v.addElem("u");
        v.addElem("v");
        v.addElem("w");
        v.addElem("x");
        v.addElem("y");
        v.addElem("z");

        System.out.println("Total de elementos: " + v.totalElem());
        System.out.println("Elemento 0: " + v.getElem(0));
        System.out.println("Elemento 1: " + v.getElem(1));

        v.removeElem("a");
        v.removeElem("b");

        System.out.println("Total de elementos: " + v.totalElem());
        System.out.println("Elemento 0: " + v.getElem(0));
        System.out.println("Elemento 1: " + v.getElem(1));
        System.out.println("Iterador: ");
        Iterator<String> i = v.Iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        


        System.out.println("listIterator");
        System.out.println("Next");
        ListIterator<String> l= v.listIterator();
        while (l.hasNext()) {
            System.out.println(l.next());
        }
        System.out.println("Previous");
        while (l.hasPrevious()) {
            System.out.println(l.previous());
        }

        System.out.println("ListIterator Index");
        System.out.println("Next");
        ListIterator<String> l2= v.listIterator(1);
        while (l2.hasNext()) {
            System.out.println(l2.next());
        }
        System.out.println("Remove \"c\"");
        v.removeElem("c");
        System.out.println("Previous:");
        while (l2.hasPrevious()) {
            System.out.println(l2.previous());
        }




    }
}
