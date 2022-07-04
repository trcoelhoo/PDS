package ex2;
import java.util.*;

public class SocialSecurity {
    private List<Person> pl = new ArrayList<>();

    public void regist(Person p){
        this.pl.add(p);
    }

    public boolean isRegisted(Person p){
        if(this.pl.contains(p)){
            return true;
        }
        else{
            return false;  
        }
    }
}
