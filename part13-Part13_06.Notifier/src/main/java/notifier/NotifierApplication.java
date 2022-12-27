package notifier;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.EventListener;

public class NotifierApplication extends Application implements EventListener {
    public void start(Stage window) {
        VBox layout = new VBox();
        TextField textBox = new TextField();
        Button button = new Button("Update");
        Label label = new Label();
        layout.getChildren().addAll(textBox,button,label);

        button.setOnAction((event) -> {
            label.setText(textBox.getText());
        });

        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
