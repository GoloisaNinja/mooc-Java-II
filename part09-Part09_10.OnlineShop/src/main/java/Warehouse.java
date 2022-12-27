import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> products;
    private Map<String, Integer> stock;
    // Constructor
    public Warehouse() {
        this.products = new HashMap<>();
        this.stock = new HashMap<>();
    }
    public void addProduct(String name, int price, int stock) {
        this.products.put(name, price);
        this.stock.put(name, stock);
    }
    public int price(String product) {
        if (this.products.containsKey(product)) {
            return this.products.get(product);
        }
        return -99;
    }
    public int stock(String product) {
        if (this.stock.containsKey(product)) {
            return this.stock.get(product);
        }
        return 0;
    }
    public boolean take(String product) {
        if (this.stock.containsKey(product)) {
            if (this.stock.get(product) >= 1) {
                int currentStock = this.stock.get(product) - 1;
                this.stock.replace(product, currentStock);
                return true;
            }
        }
        return false;
    }
    public Set<String> products() {
        return this.products.keySet();
    }
}
