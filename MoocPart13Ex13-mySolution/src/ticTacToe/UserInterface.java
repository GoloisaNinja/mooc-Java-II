package ticTacToe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.util.HashMap;
import java.util.Map;

public class UserInterface {
    private GameLogic game;

    public UserInterface(GameLogic game) {
        this.game = game;
    }

    public Parent getView(Label gameLabel) {
        return this.boardFactory(gameLabel);
    }

    private GridPane boardFactory(Label gameLabel) {
        Map<Integer, Integer> gridMap = Map.of(
                1, 1,
                2, 1,
                3, 1,
                4, 2,
                5, 2,
                6, 2,
                7, 3,
                8, 3,
                9, 3
                                              );
        GridPane boardLayout = new GridPane();
//        Label gameStatus = new Label("Turn: " + this.game.getCurrentPlayer());
//        gameStatus.setFont(Font.font("Monospaced", 40));
//        boardLayout.add(gameStatus, 0, 0);
        int column = 1;
        for (int i = 1; i < 10; i++) {
            Button gridButton = new Button(" ");
            gridButton.setPrefWidth(80);
            gridButton.setPrefHeight(80);
            boardLayout.add(gridButton, column, gridMap.get(i));
            if (i == 3 || i == 6) {
                column = 1;
            } else {
                column++;
            }
            int buttonAsBoardLocation = i;
            gridButton.setOnMouseClicked((event) -> {
                if (!this.game.isGameOver()) {
                    boolean successfulTurn = this.game.takeTurn(buttonAsBoardLocation);
                    if (successfulTurn) {
                        String currentPlayer = this.game.getCurrentPlayer();
                        gridButton.setText(currentPlayer);
                        gridButton.setFont(Font.font("Monospaced", 40));
                        boolean gameOver = this.game.isGameOver();
                        if (gameOver) {
                            gameLabel.setText("The end!");
                        } else {
                            String nextPlayer = this.game.changePlayer(currentPlayer);
                            gameLabel.setText("Turn: " + nextPlayer);
                        }

                    }
                }


            });
        }
        boardLayout.setAlignment(Pos.CENTER);
        boardLayout.setVgap(10);
        boardLayout.setHgap(10);
        boardLayout.setPadding(new Insets(10, 10, 10, 10));
        return boardLayout;
    }
}
