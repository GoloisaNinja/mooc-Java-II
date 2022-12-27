package buttonandlabel;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ButtonAndLabelApplication extends Application {

    @Override
    public void start(Stage window) {
        Button button = new Button("My Button");
        Label label = new Label("My Label");

        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(label);
        componentGroup.getChildren().add(button);

        Scene view = new Scene(componentGroup);
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}
