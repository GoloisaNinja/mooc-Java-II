import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> cart;
    // Constructor
    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }
    public void add(String name, int price) {
        Item itemToAdd = new Item(name, 1, price);
        if (!this.cart.contains(itemToAdd)) {
            this.cart.add(itemToAdd);
        } else {
            int index = this.cart.indexOf(itemToAdd);
            Item itemToIncrease = this.cart.get(index);
            itemToIncrease.increaseQuantity();
        }
    }

    public int price() {
        int sum = 0;
        for (Item item : this.cart) {
            sum += item.price();
        }
        return sum;
    }
    public void print() {
        for (Item item : this.cart) {
            System.out.println(item);
        }
    }

}
