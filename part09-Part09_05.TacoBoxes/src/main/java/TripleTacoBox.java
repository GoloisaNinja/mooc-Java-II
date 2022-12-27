public class TripleTacoBox implements TacoBox {
    private int tacos;
    // Constructor
    public TripleTacoBox() {
        this.tacos = 3;
    }
    public void eat() {
        if (this.tacos > 0) {
            this.tacos--;
        }
    }
    public int tacosRemaining() {
        return this.tacos;
    }
}
