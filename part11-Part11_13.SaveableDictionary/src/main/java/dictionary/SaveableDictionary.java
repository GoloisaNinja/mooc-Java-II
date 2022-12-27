package dictionary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class SaveableDictionary {
    private HashMap<String, String> dictionary;
    private String fileName;
    // Constructor
    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }
    // Overloaded Constructor
    public SaveableDictionary(String file) {
        this();
        this.fileName = file;
    }
    public void add(String word, String translation) {
        this.dictionary.putIfAbsent(word, translation);
    }
    public void delete(String word) {
        String keyToRemove = null;
        for (String key : this.dictionary.keySet()) {
            if (key.equals(word) || this.dictionary.get(key).equals(word)) {
                keyToRemove = key;
            }
        }
        if (keyToRemove != null) {
            this.dictionary.remove(keyToRemove);
        }

    }
    public boolean load() {
        try {
            Files.lines(Paths.get(this.fileName)).
                 map(row -> row.split(":")).
                 forEach(data -> this.add(data[0], data[1]));
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }
    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(this.fileName);
            for (String key : this.dictionary.keySet()) {
                writer.println(key + ":" + this.dictionary.get(key));
            }
            writer.close();
            return true;
        }
        catch (FileNotFoundException e) {
            return false;
        }

    }
    public String translate(String word) {
        for (String key : this.dictionary.keySet()) {
            if (key.equals(word)) {
                return this.dictionary.get(key);
            }
            if (this.dictionary.get(key).equals(word)) {
                return key;
            }
        }
        return null;
    }
}
