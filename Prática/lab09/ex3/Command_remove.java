import java.util.Collection;
import java.util.Stack;

public class Command_remove<T> implements Command<T>{

    private Collection<T> collection;
    private Stack<T> pilha;

    public Command_remove(Collection<T> collection){
        this.collection = collection;
        pilha = new Stack<T>();
    }

    @Override
    public boolean execute(T element) {
        
        try {
            collection.remove(element);
            pilha.push(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean undo() {
               
        if (pilha.isEmpty()){
            return false;
        }
        T element = pilha.pop();
        collection.add(element);
        return true;
    }

}