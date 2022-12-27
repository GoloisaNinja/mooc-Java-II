import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    private ArrayList<Item> items;
    private int capacity;
    // Constructor
    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }
    @Override
    public void add(Item item) {
        int itemWeight = item.getWeight();
        if (itemWeight <= capacity) {
            this.items.add(item);
            this.capacity -= itemWeight;
        }
    }
    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
}
