package ticTacToe;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import javax.swing.*;
import java.util.EventListener;

public class TicTacToeApplication extends Application {
    GameLogic game = new GameLogic();
    @Override
    public void start(Stage window) {
        BorderPane base = new BorderPane();
        base.setPrefSize(500, 500);
        base.setPadding(new Insets(20, 20, 20, 20));
        Label gameStatus = new Label(this.game.getGameMessage());
        gameStatus.setFont(Font.font("Monospaced", 40));
        gameStatus.setTextAlignment(TextAlignment.CENTER);
        base.setTop(gameStatus);
        UserInterface ui = new UserInterface(game);
        Parent board = ui.getView(gameStatus);
        base.setCenter(board);
        Scene view = new Scene(base);
        window.setScene(view);
        window.show();
    }
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
