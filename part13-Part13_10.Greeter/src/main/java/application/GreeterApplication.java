package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.EventListener;

public class GreeterApplication extends Application implements EventListener {
    @Override
    public void start(Stage window) {
        GridPane inputLayout = new GridPane();
        Label instructions = new Label("Enter your name click start.");
        TextField name = new TextField();
        Button start = new Button("Start");

        inputLayout.add(instructions, 0, 0);
        inputLayout.add(name, 0, 1);
        inputLayout.add(start, 0, 2);

        inputLayout.setPrefSize(300, 180);
        inputLayout.setAlignment(Pos.CENTER);
        inputLayout.setVgap(20);
        inputLayout.setHgap(20);
        inputLayout.setPadding(new Insets(20, 20, 20, 20));

        StackPane greeterLayout = new StackPane();
        Label welcome = new Label("");

        greeterLayout.getChildren().add(welcome);
        greeterLayout.setPrefSize(300, 180);
        greeterLayout.setAlignment(Pos.CENTER);
        greeterLayout.setPadding(new Insets(20,20,20,20));

        Scene inputView = new Scene(inputLayout);
        Scene greeterView = new Scene(greeterLayout);

        start.setOnAction((event) -> {
            String inputName = name.getText();
            welcome.setText("Welcome " + inputName + "!");
            window.setScene(greeterView);
        });


        window.setScene(inputView);
        window.show();
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
