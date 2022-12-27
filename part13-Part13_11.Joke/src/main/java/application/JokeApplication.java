package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.EventListener;

public class JokeApplication extends Application implements EventListener {
    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        HBox menu = new HBox();
        Button jokeBtn = new Button("Joke");
        Button answerBtn = new Button("Answer");
        Button expBtn = new Button("Explanation");
        menu.getChildren().addAll(jokeBtn, answerBtn, expBtn);
        menu.setSpacing(20);

        layout.setTop(menu);

        StackPane jokeLayout = createView("What do you call a bear with no teeth?");
        StackPane answerLayout = createView("A gummy bear.");
        StackPane expLayout = createView("Get it? Because he has no teeth so he has to gum everything!");

        layout.setCenter(jokeLayout);
        jokeBtn.setOnAction((event) -> {
            layout.setCenter(jokeLayout);
        });
        answerBtn.setOnAction((event) -> {
            layout.setCenter(answerLayout);
        });
        expBtn.setOnAction((event) -> {
            layout.setCenter(expLayout);
        });
        Scene jokeView = new Scene(layout);
        window.setScene(jokeView);
        window.show();
    }

    private StackPane createView(String text) {
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        Label dynamicText = new Label(text);
        dynamicText.setAlignment(Pos.CENTER);
        dynamicText.setWrapText(true);
        layout.getChildren().add(dynamicText);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10, 10, 10, 10));

        return layout;
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}
