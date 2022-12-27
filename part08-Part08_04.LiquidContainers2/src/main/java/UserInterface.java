import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Container firstContainer;
    private Container secondContainer;
    // Constructor
    public UserInterface(Scanner scanner, Container firstContainer, Container secondContainer) {
        this.scanner = scanner;
        this.firstContainer = firstContainer;
        this.secondContainer = secondContainer;
    }
    public void start() {
        while (true) {
            System.out.println("First: " + firstContainer);
            System.out.println("Second: " + secondContainer);
            String input = this.scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.parseInt(parts[1]);
            switch(command) {
                case "add": {
                    firstContainer.add(amount);
                    break;
                }
                case "remove": {
                    secondContainer.remove(amount);
                    break;
                }
                case "move": {
                    if (firstContainer.contains() - amount < 0) {
                        amount = firstContainer.contains();
                    }
                    firstContainer.remove(amount);
                    secondContainer.add(amount);
                    break;
                }
                default:
                    System.out.println("Unknown command...");
            }
        }
    }
}
