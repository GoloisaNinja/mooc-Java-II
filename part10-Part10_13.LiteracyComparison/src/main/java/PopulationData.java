public class PopulationData implements Comparable<PopulationData> {
    private String country;
    private int year;
    private String gender;
    private double literacyRate;
    public PopulationData(String country, int year, String gender, double literacyRate) {
        this.country = country;
        this.year = year;
        this.gender = gender.split(" ")[1];
        this.literacyRate = literacyRate;
    }
    @Override
    public int compareTo(PopulationData data) {
        if (this.literacyRate < data.literacyRate) {
            return -1;
        } else if (this.literacyRate > data.literacyRate) {
            return 1;
        }
        return 0;
    }
    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.literacyRate;
    }
}
