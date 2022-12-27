public class Hideout<T> {
    private T item;
    public Hideout() {
        this.item = null;
    }
    public void putIntoHideout(T toHide) {
        this.item = toHide;
    }
    public T takeFromHideout() {
        T helper = this.item;
        this.item = null;
        return helper;
    }
    public boolean isInHideout() {
        return this.item != null;
    }
}
