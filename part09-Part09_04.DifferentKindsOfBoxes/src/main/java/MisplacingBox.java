public class MisplacingBox extends Box {
    @Override
    public boolean isInBox(Item item) {
        return false;
    }
    @Override
    public void add(Item item) {}
}
