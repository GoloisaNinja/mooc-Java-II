
public class Program {

    public static void main(String[] args) {
        // Test your method here
        int[][] matrix = {
                {3, 2, 7, 6},
                {2, 4, 1, 0},
                {3, 2, 1, 0}
        };

        System.out.println(arrayAsString(matrix));
    }
    public static String arrayAsString(int[][] array) {
        StringBuilder returnString = new StringBuilder("");
        for (int[] row : array) {
            for (int column : row) {
                returnString.append(column);
            }
            returnString.append("\n");
        }
        return returnString.toString();
    }
}
