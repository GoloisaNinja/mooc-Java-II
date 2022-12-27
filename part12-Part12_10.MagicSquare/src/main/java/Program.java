import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        // Test the MagicSquare class here
        
        MagicSquareFactory msFactory = new MagicSquareFactory();
        //System.out.println(msFactory.createMagicSquare(5));
        MagicSquare square = msFactory.createMagicSquare(5);
        square.giveAllNumbers();
        System.out.println(square);
        System.out.println(square.allNumbersDifferent());
        ArrayList<Integer> sumRows = square.sumsOfRows();
        ArrayList<Integer> sumColumns = square.sumsOfColumns();
        ArrayList<Integer> sumDiagonals = square.sumsOfDiagonals();
        System.out.println(sumRows);
        System.out.println(sumColumns);
        System.out.println(sumDiagonals);
        System.out.println(square.sumsAreSame());
        System.out.println(square.isMagicSquare());
    }
}
