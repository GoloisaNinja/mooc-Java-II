public class CustomTacoBox implements TacoBox {
    private int tacos;
    // Constructor
    public CustomTacoBox(int tacos) {
        this.tacos = tacos;
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
