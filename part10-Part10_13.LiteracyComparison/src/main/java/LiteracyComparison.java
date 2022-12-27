import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LiteracyComparison {
    public static void main(String[] args) {
        List<String> popData = new ArrayList<>();
        try {
            Files.lines(Paths.get("literacy.csv"))
                 .forEach(s -> popData.add(s));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        popData.stream().
               map(s -> s.split(",")).
               map(data -> new PopulationData(data[3], Integer.parseInt(data[4]), data[2],
                                              Double.parseDouble(data[5]))).
               sorted().
               forEach(System.out::println);
    }
}
