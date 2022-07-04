package ex3;

import java.util.*;


public class Library {
    List <Livros> l = new ArrayList<>();


    public void addBook (Livros book){
        l.add(book);
    }

    public Livros getLivro(int i){
        return this.l.get(i-1);
    }

    public void print(){
        int i=1;
        for (Livros ll : l){
            System.out.println(i+"\t"+ll);
            i++;
        }
    }
}