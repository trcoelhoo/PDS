import java.util.*;

public class Client extends Observer {
    private String name;
    private String c;
    private List<Product> products=new ArrayList<Product>();
    public Client(String c, String name) {
        this.name = name;
        this.c = c;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void getnotified(Product p) {
        System.out.println("Client " + this.name + " want to get notified about " + p.description());
        this.products.add(p);
    }

    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", number=" + c + '}';
    }

    @Override
    public void update(Product p) {
        System.out.println("Client " + this.name + " this product is available: " + p.toString());
    }
}
