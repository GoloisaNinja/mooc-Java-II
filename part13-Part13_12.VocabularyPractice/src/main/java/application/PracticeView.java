package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PracticeView {
    private MyDictionary dictionary;
    private String word;
    public PracticeView(MyDictionary dictionary) {
        this.dictionary = dictionary;
        this.word = this.dictionary.randomPractice();
    }
    private void setWord() {
        this.word = this.dictionary.randomPractice();
    }
    public Parent getView() {
        GridPane practiceLayout = new GridPane();
        String instruction = "Translate the word: ";
        Label practiceLabel = new Label(instruction + word);
        TextField input = new TextField();
        Button check = new Button("Check");
        Label outcome = new Label("");
        practiceLayout.add(practiceLabel, 0, 0);
        practiceLayout.add(input, 0, 1);
        practiceLayout.add(check, 0, 2);
        practiceLayout.add(outcome, 0, 3);
        practiceLayout.setAlignment(Pos.CENTER);
        practiceLayout.setVgap(10);
        practiceLayout.setPadding(new Insets(10, 10, 10, 10));

        check.setOnMouseClicked((event) -> {
            String translation = dictionary.getTranslation(word);
            if (translation.equals(input.getText())) {
                outcome.setText("Correct!");
            } else {
                outcome.setText("Incorrect!");
            }
            input.clear();
            this.setWord();
            practiceLabel.setText(instruction + this.word);
        });

        return practiceLayout;
    }
}
