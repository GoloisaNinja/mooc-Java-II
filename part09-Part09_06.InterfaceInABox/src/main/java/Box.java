import java.util.ArrayList;

public class Box implements Packable {
    private ArrayList<Packable> contents;
    private double maxCapacity;
    // Constructor
    public Box(double maxCapacity) {
        this.contents = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }
    public void add(Packable itemToAdd) {
        if (this.weight() + itemToAdd.weight() <= maxCapacity) {
            this.contents.add(itemToAdd);
        }
    }
    public double weight() {
        if (this.contents.isEmpty()) {
            return 0;
        }
        double weightToReturn = 0.0;
        for (Packable item : this.contents) {
            weightToReturn += item.weight();
        }
        return weightToReturn;
    }
    public String toString() {
        //String itemOrItems = this.contents.size() == 1 ? "item" : "items";
        return "Box: " + this.contents.size() + " items, total weight " + this.weight() + " kg";
    }
}
