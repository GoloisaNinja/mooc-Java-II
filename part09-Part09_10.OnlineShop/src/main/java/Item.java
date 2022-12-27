public class Item {
    private String name;
    private int qty;
    private int unitPrice;
    // Constructor
    public Item(String name, int qty, int unitPrice) {
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    public int price() {
        return this.unitPrice * this.qty;
    }
    public void increaseQuantity() {
        this.qty++;
    }
    @Override
    public String toString() {
        return this.name + ": " + this.qty;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Item compared = (Item) obj;
        return this.name.equals(compared.name) && this.unitPrice == compared.unitPrice;
    }
}
