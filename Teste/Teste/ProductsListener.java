import java.util.List;

public interface ProductsListener {

	public List<Product> newprods(Product[] arr);
    public List<Product> newprods(String file);
}