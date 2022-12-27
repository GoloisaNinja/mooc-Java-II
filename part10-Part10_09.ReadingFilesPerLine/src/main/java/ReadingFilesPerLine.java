
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadingFilesPerLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test the method here
        try {
            List<String> result = read("text.txt");
            result.stream().forEach(System.out::println);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static List<String> read(String file) throws IOException {
        return Files.lines(Paths.get(file)).collect(Collectors.toList());
    }
}
