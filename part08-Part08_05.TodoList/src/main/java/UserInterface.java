import java.util.Scanner;
public class UserInterface {
    private Scanner scanner;
    private TodoList list;
    // Constructor
    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }
    public void start() {
        while(true) {
            System.out.println("Command:");
            String command = this.scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }
            switch(command) {
                case "add":
                    this.addTask();
                    break;
                case "remove":
                    this.removeTask();
                    break;
                case "list":
                    this.list.print();
                    break;
                default:
                    System.out.println("Unknown command...");
                    break;
            }
        }
    }
    public void addTask() {
        System.out.println("To add:");
        String task = this.scanner.nextLine();
        this.list.add(task);
    }
    public void removeTask() {
        System.out.println("Which one is removed?");
        int taskNumber = Integer.parseInt(this.scanner.nextLine());
        this.list.remove(taskNumber);
    }
}
