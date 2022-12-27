package ticTacToe;

import java.util.HashMap;

public class GameLogic {
    private HashMap<Integer, String> board;
    private String player;
    private String gameMessage;
    public GameLogic() {
        this.board = new HashMap<>();
        this.player = "X";
        this.gameMessage = "Turn: " + this.player;
    }
    public String getCurrentPlayer() {
        return this.player;
    }
    public String getGameMessage() {
        return this.gameMessage;
    }

    public boolean takeTurn(int boardLocation) {
        if (this.board.get(boardLocation) == null) {
            this.board.put(boardLocation, this.player);
            return true;
        }
        return false;
    }
    public String changePlayer(String currentPlayer) {
        String base = "Turn: ";
        if (currentPlayer == "X") {
            this.player = "O";
            this.gameMessage = base + this.player;
            return this.player;
        } else {
            this.player = "X";
            this.gameMessage = base + this.player;
            return this.player;
        }
    }
    public boolean checkXAxisWin(int bound) {
        if (bound > 9) {
            return false;
        }
        String playerWin = this.player + this.player + this.player;
        String win = "";
        int start = bound - 2;
        while(bound >= start) {
            win += this.board.get(start);
            start++;
        }
        if (win.equals(playerWin)) {
            return true;
        }
        return this.checkXAxisWin(bound + 3);
    }
    public boolean checkYAxisWin(int columnStart) {
        if (columnStart > 3) {
            return false;
        }
        String playerWin = this.player + this.player + this.player;
        int pos1 = columnStart;
        int pos2 = columnStart + 3;
        int pos3 = pos2 + 3;
        String win = "";
        win += this.board.get(pos1) + this.board.get(pos2) + this.board.get(pos3);
        if (win.equals(playerWin)) {
            return true;
        }
        return this.checkYAxisWin(columnStart + 1);
    }
    public boolean checkDiagonalWin() {
        String playerWin = this.player + this.player + this.player;
        String leftWin = "";
        String rightWin = "";
        leftWin += this.board.get(1) + this.board.get(5) + this.board.get(9);
        rightWin += this.board.get(3) + this.board.get(5) + this.board.get(7);
        if (leftWin.equals(playerWin) || rightWin.equals(playerWin)) {
            return true;
        }
        return false;
    }
    public boolean isGameOver() {
        return this.checkXAxisWin(3) || this.checkYAxisWin(1) || this.checkDiagonalWin();
    }
}
