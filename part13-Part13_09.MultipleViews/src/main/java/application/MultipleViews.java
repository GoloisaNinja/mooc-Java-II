package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.EventListener;

public class MultipleViews extends Application implements EventListener {
    @Override
    public void start(Stage window) {
        BorderPane fLayout = new BorderPane();
        Label fText = new Label("First view!");
        Button fButton = new Button("To the second view!");
        fLayout.setTop(fText);
        fLayout.setCenter(fButton);

        Scene fView = new Scene(fLayout);

        VBox sLayout = new VBox();
        Button sButton = new Button("To the third view!");
        Label sText = new Label("Second view!");
        sLayout.getChildren().addAll(sButton, sText);

        Scene sView = new Scene(sLayout);

        GridPane tLayout = new GridPane();
        Label tText = new Label("Third view!");
        Button tButton = new Button("To the first view!");
        tLayout.add(tText, 0, 0);
        tLayout.add(tButton, 1, 1);

        Scene tView = new Scene(tLayout);

        fButton.setOnAction((event) -> {
            window.setScene(sView);
        });

        sButton.setOnAction((event) -> {
            window.setScene(tView);
        });

        tButton.setOnAction((event) -> {
            window.setScene(fView);
        });

        window.setScene(fView);
        window.show();

    }
    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
