public class Book {
    private String name;
    private int ageRecommendation;
    public Book(String name, int ageRecommendation) {
        this.name = name;
        this.ageRecommendation = ageRecommendation;
    }
    // Getters
    public String getName() {
        return name;
    }
    public int getAgeRecommendation() {
        return ageRecommendation;
    }
}
