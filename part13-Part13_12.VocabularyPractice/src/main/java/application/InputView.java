package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class InputView {
    private MyDictionary dictionary;
    public InputView(MyDictionary dictionary) {
        this.dictionary = dictionary;
    }
    public Parent getView() {
        GridPane inputLayout = new GridPane();
        Label wordLabel = new Label("Word");
        TextField foreignWord = new TextField();
        Label translationLabel = new Label("Translation");
        TextField englishWord = new TextField();
        Button addWords = new Button("Add the word pair");
        inputLayout.add(wordLabel, 0, 0);
        inputLayout.add(foreignWord, 0, 1);
        inputLayout.add(translationLabel, 0, 2);
        inputLayout.add(englishWord, 0, 3);
        inputLayout.add(addWords, 0, 4);
        inputLayout.setAlignment(Pos.CENTER);
        inputLayout.setVgap(10);
        inputLayout.setPadding(new Insets(10, 10, 10, 10));

        addWords.setOnMouseClicked((event) -> {
            String w1 = foreignWord.getText();
            String w2 = englishWord.getText();
            dictionary.add(w1, w2);
            foreignWord.clear();
            englishWord.clear();
        });

        return inputLayout;
    }
}
