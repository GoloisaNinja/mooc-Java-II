import java.util.HashMap;

public class Abbreviations {
    private HashMap<String, String> abbreviations;
    // Constructor
    public Abbreviations() {
        this.abbreviations = new HashMap<>();
    }
    public boolean hasAbbreviation(String abbreviation) {
        return this.abbreviations.containsKey(abbreviation);
    }
    public void addAbbreviation(String abbreviation, String explanation) {
        if (!hasAbbreviation(abbreviation)) {
            this.abbreviations.put(abbreviation, explanation);
        }
    }
    public String findExplanationFor(String abbreviation) {
        return this.abbreviations.get(abbreviation);
    }
}
