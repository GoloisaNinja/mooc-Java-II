public class Container {
    private int amount;
    // Constructor
    public Container() {
        this.amount = 0;
    }
    public int contains() {
        return this.amount;
    }
    public void add(int amt) {
        if (amt > 0) {
            if (this.amount + amt > 100) {
                this.amount = 100;
            } else {
                this.amount += amt;
            }
        }
    }
    public void remove(int amt) {
        if (amt > 0) {
            if (this.amount - amt < 0) {
                this.amount = 0;
            } else {
                this.amount -= amt;
            }
        }
    }
    @Override
    public String toString() {
        return this.amount + "/100";
    }
}
