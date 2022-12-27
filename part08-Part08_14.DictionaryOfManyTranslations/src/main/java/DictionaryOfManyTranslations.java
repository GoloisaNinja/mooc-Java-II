import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> dictionary;
    // Constructor
    public DictionaryOfManyTranslations() {
        this.dictionary = new HashMap<>();
    }
    // Methods
    public void add(String word, String translation) {
        this.dictionary.putIfAbsent(word, new ArrayList<>());
        if (!this.dictionary.get(word).contains(translation)) {
            this.dictionary.get(word).add(translation);
        }
    }
    public void remove(String word) {
        this.dictionary.remove(word);
    }
    public ArrayList<String> translate(String word) {
        if (this.dictionary.containsKey(word)) {
            return this.dictionary.get(word);
        } else {
            return new ArrayList<>();
        }
    }

}
