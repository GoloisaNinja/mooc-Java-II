
import java.util.*;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        while (true) {
            System.out.println("Input the name of the book, empty stops:");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            String name = input;
            System.out.println("Input the age recommendation:");
            int age = Integer.parseInt(scanner.nextLine());
            Book newBook = new Book(name, age);
            books.add(newBook);
        }
        Comparator<Book> comparator = Comparator.comparing(Book::getAgeRecommendation)
                                                .thenComparing(Book::getName);
        Collections.sort(books, comparator);
        System.out.println(books.size() + " books in total.");
        System.out.println();
        System.out.println("Books:");
        for (Book book : books) {
            System.out.println(
                    book.getName() + " (recommended for " + book.getAgeRecommendation() + " year-olds or older)");
        }

    }

}
