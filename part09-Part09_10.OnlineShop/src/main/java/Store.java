import java.util.Scanner;
import java.util.Set;

public class Store {

    private Warehouse warehouse;
    private Scanner scanner;

    public Store(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }

    // the method that handles the customers visit to the store.
    public void shop(String customer) {
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Welcome to the store " + customer);
        System.out.println("our selection:");

        for (String product : this.warehouse.products()) {
            System.out.println(product);
        }

        while (true) {
            System.out.print("What to put in the cart (press enter to go to the register): ");
            String product = scanner.nextLine();
            if (product.isEmpty()) {
                break;
            }

            // Add code here that adds the product to the cart,
            // If there is any in the warehouse, and reduces the stock in the warehouse
            // Don't touch any of the other code!
            Set productList = this.warehouse.products();
            if (productList.contains(product)) {
               boolean canTakeFromWarehouse = this.warehouse.take(product);
               if (canTakeFromWarehouse) {
                   int productPrice = this.warehouse.price(product);
                   cart.add(product, productPrice);
               } else {
                   System.out.println("Sorry...product is out of stock.");
               }
            } else {
                System.out.println("Sorry...product is out of stock.");
            }
        }

        System.out.println("your shoppingcart contents:");
        cart.print();
        System.out.println("total: " + cart.price());
    }
}