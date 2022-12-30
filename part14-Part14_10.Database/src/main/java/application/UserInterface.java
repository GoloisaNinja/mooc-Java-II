package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here
            switch(command) {
                case "1":
                    try {
                        this.list();
                    }
                    catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "2":
                    try {
                        this.add();
                        break;
                    }
                    catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                case "3":
                    try {
                        this.markDone();
                        break;
                    }
                    catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                case "4":
                    try {
                        this.remove();
                        break;
                    }
                    catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }

        System.out.println("Thank you!");
    }
    private void list() throws Exception {
        System.out.println("Listing the database contents");
        List<Todo> todos = this.database.list();
        for (Todo todo : todos) {
            System.out.println(todo);
        }
    }
    private void add() throws Exception {
        System.out.println("Adding a new todo");
        System.out.println("Enter name");
        String name = this.scanner.nextLine();
        System.out.println("Enter description");
        String description = this.scanner.nextLine();
        List<Todo> existingList = this.database.list();
        int id = existingList.size() + 1;
        Todo newTodo = new Todo(id, name, description, Boolean.FALSE);
        this.database.add(newTodo);
    }
    private void markDone() throws Exception {
        System.out.println("Which todo should be marked as done (give the id)?");
        int id = Integer.parseInt(this.scanner.nextLine());
        this.database.markAsDone(id);
    }
    private void remove() throws Exception {
        System.out.println("Which todo should be removed (give the id)?");
        int id = Integer.parseInt(this.scanner.nextLine());
        this.database.remove(id);
    }
}
