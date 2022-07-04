import java.util.*;
public class Command_add<T> implements Command<T>{
    private Collection<T> collection;
    private Stack<T> pilha;
    
    public Command_add(Collection<T> collection){
        this.collection = collection;
        this.pilha = new Stack<T>();
    }
    
    @Override
    public boolean execute(T element){
        try{
            collection.add(element);
            pilha.push(element);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    @Override
    public boolean undo(){
        if(pilha.isEmpty()){
            return false;
        }
        else{
            collection.remove(pilha.pop());
            return true;
        }
    }
    
}
