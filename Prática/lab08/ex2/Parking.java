package ex2;
import java.util.*;
public class Parking {
    
    private List<Person> pl = new ArrayList<>();

    public void allow(Person p){
        this.pl.add(p);
    }
    public boolean isallowed(Person p){
        if(this.pl.contains(p)){
            return true;
        }
        else{
            return false;
        }
    }
}
