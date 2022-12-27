package application;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// END SOLUTION
public class VocabularyPracticeApplication extends Application {
    MyDictionary dictionary = new MyDictionary();
    @Override
    public void start(Stage window) {

        BorderPane baseLayout = new BorderPane();
        baseLayout.setPrefSize(500, 500);
        baseLayout.setPadding(new Insets(10, 10, 10, 10));
        HBox menu = new HBox();
        Button addWordsBtn = new Button("Enter new words");
        Button practiceBtn = new Button("Practice");
        menu.getChildren().addAll(addWordsBtn, practiceBtn);
        menu.setSpacing(20);
        baseLayout.setTop(menu);
        InputView input = new InputView(dictionary);
        Parent inputView = input.getView();
        PracticeView practice = new PracticeView(dictionary);
        Parent practiceView = practice.getView();
        baseLayout.setCenter(inputView);
        Scene view = new Scene(baseLayout);
        addWordsBtn.setOnMouseClicked((event) -> {
            baseLayout.setCenter(inputView);
        });
        practiceBtn.setOnMouseClicked((event) -> {
            baseLayout.setCenter(practiceView);
        });
        window.setScene(view);
        window.show();

    }
    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}
