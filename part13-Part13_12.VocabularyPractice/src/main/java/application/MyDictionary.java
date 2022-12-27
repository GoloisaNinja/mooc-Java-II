package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MyDictionary {
    private HashMap<String, String> dictionary;
    private List<String> words;

    public MyDictionary() {
        this.dictionary = new HashMap<>();
        this.words = new ArrayList<>();
        this.add("hefiner", "shoe");
    }
    public void add(String word, String translation) {
        if (!this.dictionary.containsKey(word)) {
            this.dictionary.put(word, translation);
            words.add(word);
        }
    }
    public String getTranslation(String word) {
        return this.dictionary.get(word);
    }
    public String randomPractice() {
        int randomIndex = new Random().nextInt(this.dictionary.size());
        return this.words.get(randomIndex);
    }
    public List<String> getKeys() {
        List<String> keys = new ArrayList<>();
        keys.addAll(this.dictionary.keySet());
        return keys;
    }
}
