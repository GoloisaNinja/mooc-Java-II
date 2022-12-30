package smiley;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {
    @Override
    public void start(Stage stage) {
        Canvas smileyCanvas = new Canvas(200, 200);
        GraphicsContext painter = smileyCanvas.getGraphicsContext2D();

        BorderPane smileyLayout = new BorderPane();
        smileyLayout.setCenter(smileyCanvas);
        painter.setFill(Color.BLACK);
        painter.fillRect(55, 75, 20, 20);
        painter.fillRect(120, 75, 20, 20);
        painter.fillRect(40, 155, 20, 20);
        painter.fillRect(60, 175, 20, 20);
        painter.fillRect(80, 175, 20, 20);
        painter.fillRect(100, 175, 20, 20);
        painter.fillRect(120, 175, 20, 20);
        painter.fillRect(140, 155, 20, 20);


        Scene view = new Scene(smileyLayout);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
