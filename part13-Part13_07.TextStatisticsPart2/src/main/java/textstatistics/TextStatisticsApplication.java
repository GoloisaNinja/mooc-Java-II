package textstatistics;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.EventListener;

public class TextStatisticsApplication extends Application implements EventListener {

    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        TextArea text = new TextArea();
        HBox texts = new HBox();
        texts.setSpacing(10);
        String lettersStr = "Letters: ";
        String wordsStr = "Words: ";
        String longestStr = "The longest word is: ";
        Label text1 = new Label(lettersStr + 0);
        Label text2 = new Label(wordsStr + 0);
        Label text3 = new Label(longestStr);
        text.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts).sorted((s1, s2) -> s2.length() - s1.length()).findFirst().get();
            text1.setText(lettersStr + characters);
            text2.setText(wordsStr + words);
            text3.setText(longestStr + longest);
        });


        texts.getChildren().add(text1);
        texts.getChildren().add(text2);
        texts.getChildren().add(text3);

        layout.setCenter(text);
        layout.setBottom(texts);

        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
       launch(TextStatisticsApplication.class);
    }

}
