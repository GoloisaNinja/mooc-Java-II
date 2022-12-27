
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }
    public static List<Book> readBooks(String file) throws IOException {
       return Files.lines(Paths.get(file)).
               map(row -> row.split(",")).
               map(data -> new Book(data[0], Integer.parseInt(data[1]),
                                    Integer.parseInt(data[2]),
                                    data[3])).
               collect(Collectors.toList());
    }
}
