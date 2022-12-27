import java.util.ArrayList;

public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);
        ArrayList<Integer> addedNums = new ArrayList<>();
        // implement the creation of a magic square with the Siamese method algorithm here
        int[] boardXY = {0, size / 2};
        int numberToAdd = 1;
        while(addedNums.size() < size * size) {
            square.placeValue(boardXY[1], boardXY[0], numberToAdd);
            addedNums.add(numberToAdd);
            numberToAdd++;
            // setup our next move
            int[] downMoveIfBoardSpotIsFull = {boardXY[0] + 1, boardXY[1]};
            boardXY[0] -= 1;
            boardXY[1] += 1;
            if (boardXY[0] < 0) {
                // moving up goes off board
                boardXY[0] = size - 1;
            }
            if (boardXY[1] > size - 1) {
                boardXY[1] = 0;
            }
            // look ahead if spot is empty
            int boardSpotEmpty = square.readValue(boardXY[1], boardXY[0]);
            if (boardSpotEmpty != 0) {
                boardXY = downMoveIfBoardSpotIsFull;
            }
        }
        return square;
    }

}
