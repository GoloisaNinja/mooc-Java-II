import java.util.ArrayList;

public class OneItemBox extends Box {
    private ArrayList<Item> box;
    public OneItemBox() {
        this.box = new ArrayList<>();
    }
    @Override
    public void add(Item item) {
        if (this.box.isEmpty()) {
            this.box.add(item);
        }
    }
    @Override
    public boolean isInBox(Item item) {
        return this.box.contains(item);
    }
}
