import java.util.*;
public class ex3_main {
    public static void main(String[] args) {
        ArrayList<String> ourList = new ArrayList<>();
        Command_add<String> addCommand = new Command_add<>(ourList);
        Command_remove <String> removeCommand = new Command_remove<>(ourList);

        addCommand.execute("Hello");
        addCommand.execute("World");

        System.out.println("Size: "+ourList.size());
        if(ourList.size()>1){
            System.out.println("index 0: " + ourList.get(0));
            System.out.println("index 1: " + ourList.get(1));
        }

        addCommand.undo();
        System.out.println("index 0: " + ourList.get(0));

        removeCommand.execute("Hello");
        System.out.println("Size: " + ourList.size());

        removeCommand.undo();
        System.out.println("index 0: " + ourList.get(0));
    }
}
