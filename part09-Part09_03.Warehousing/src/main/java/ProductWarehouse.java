public class ProductWarehouse extends Warehouse {
    private String productName;
    // Constructor
    public ProductWarehouse(String productName, double capacity) {
        super(capacity);
        this.productName = productName;
    }
    // Getter
    public String getName() {
        return this.productName;
    }
    // Setter
    public void setName(String newName) {
        this.productName = newName;
    }
    @Override
    public String toString() {
        return this.productName + ": " + super.toString();
    }
}
