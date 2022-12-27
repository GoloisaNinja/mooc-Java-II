package buttonandtextfield;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ButtonAndTextFieldApplication extends Application {
    @Override
    public void start(Stage window) {
        Button button = new Button("this is a button");
        TextField text = new TextField("And here is a bunch of text in a taxt field");
        BorderPane layout = new BorderPane();
        layout.setTop(button);
        layout.setBottom(text);
        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

}
