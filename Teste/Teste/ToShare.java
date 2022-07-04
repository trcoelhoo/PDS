

import java.util.*;

public class ToShare {
    public List<Product> products;
    private List<Product> productsShared;
    private Iterator<Product> iterator;
    protected ArrayList<ProductsListener> listeners;
    private List<Client> clients;

    public ToShare(){
        this.products = new ArrayList<Product>();
        this.productsShared = new ArrayList<Product>();
        this.listeners = new ArrayList<ProductsListener>();
        this.iterator = this.products.iterator();
        this.clients = new ArrayList<Client>();

    }
    public void addArr(Product[] products) {
        NewProdList l=new NewProdList();
        List<Product> list = l.newprods(products);
        for(Product p:list){

            add(p);
        }
       
    }

    public void addF(String file){
        NewProdList l=new NewProdList();
        List<Product> list = l.newprods(file);
        for(Product p:list){

            add(p);
        }
    }

    public boolean add(Product p){
        
        return this.products.add(p);
    }

    public Product remove(String code){
        for(Product p : this.products){
            if(p.code().equals(code)){
                this.products.remove(p);
                return p;
            }
        }
        return null;
    }

    public Product remove(Product p){
        return this.products.remove(p) ? p : null;
    }

    public boolean share(String code, Client user){
        Product p = this.remove(code);
        if(p != null){
            user.getnotified(p);
            this.clients.add(user);
            this.productsShared.add(p);
            return true;
        }
        return false;
    }

    public boolean share(Product p, Client user){
        return this.share(p.code(), user);
    }

    public boolean giveBack(String code){
        for(Product p : this.productsShared){
            if(p.code().equals(code)){
                this.products.add(p);
                this.productsShared.remove(p);
                notify(p);
                return true;
            }
        }
        return false;

    }

    public void notify(Product p){
        for(Client c : this.clients){
            if (c.getProducts().contains(p)) {
                c.update(p);
            }
        }
    }
    public boolean giveBack(Product p){
        return this.giveBack(p.code());
    }

    public List<Product> getProducts(){
        return this.products;
    }

    public int totalProducts(){
        return this.products.size();
    }

    public String sharedProducts(){
        StringBuilder sb = new StringBuilder();
        sb.append("Total: " + this.productsShared.size() + "\n        ");
        for(Product p : this.productsShared){
            sb.append(p.toString()).append("\n        ");
        }
        return sb.toString();
        
    }




}
    

