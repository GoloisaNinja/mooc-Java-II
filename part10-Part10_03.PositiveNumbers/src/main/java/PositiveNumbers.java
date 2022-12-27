
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(-3);
        numbers.add(10);
        numbers.add(-4);
        numbers.add(6);
        numbers.add(0);
        numbers.add(1);
        numbers.add(12);
        List<Integer> positives = positive(numbers);
        for (int number : positives) {
            System.out.println(number);
        }
    }
    public static List<Integer> positive(List<Integer> numbers) {
        return numbers.stream().filter(n -> n > 0).collect(Collectors.toList());
    }

}
