
import java.io.File;
import java.util.*;

public class NewProdList implements ProductsListener {

    public List<Product> newprods(Product[] arr) {
        List<Product> list = new ArrayList<Product>();
        for (Product p : arr) {
            list.add(p);
        }
        return list;
    }

    public List<Product> newprods(String filename){
        List<Product> list = new ArrayList<Product>();
        
        File file = new File(filename);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (Exception e) {
            System.out.println("Erro ao abrir o arquivo");
            return null;
        }
        while (sc.hasNextLine()) {

            try{
                String line = sc.nextLine();
                String[] fields = line.split("\t");

                String c=fields[0];
                Product p=null;
                if(c.equals("Car")){
                    p = new Car(fields[1], fields[2], Double.parseDouble(fields[3]));
                }else if(c.equals("Jeep")){
                    p = new Jeep(new OldJeep(fields[1]));
                }else if(c.equals("Motorcycle")){
                    p = new Motorcycle(fields[1], fields[2], Double.parseDouble(fields[3]));
                }else if (c.equals("Van")) {
                    p = new Van(fields[1], fields[2], Double.parseDouble(fields[3]));
                }else{
                    
                    System.out.println("Invalid product type");
                }
                if (p != null) {
                    list.add(p);
                }
            }
            catch(Exception e){
                System.out.println("Erro ao ler o arquivo");
                return null;
            }


        }
        sc.close();
        return list;

    }
    
}
