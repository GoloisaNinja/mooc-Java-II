package title;


import javafx.application.Application;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide a title:");
        String title = scanner.nextLine();
        String paramsTitle = "--title=" + title;
        Application.launch(UserTitle.class, paramsTitle);

    }

}
