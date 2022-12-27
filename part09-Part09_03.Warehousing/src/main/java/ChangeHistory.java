import java.util.ArrayList;

public class ChangeHistory {
    private ArrayList<Double> history;
    // Constructor
    public ChangeHistory() {
        this.history = new ArrayList<>();
    }
    public void add(double status) {
        this.history.add(status);
    }
    public void clear() {
        this.history.clear();
    }
    private boolean historyIsEmpty() {
        return this.history.isEmpty();
    }
    public double maxValue() {
        if (this.historyIsEmpty()) {
            return 0;
        }
        double largest = this.history.get(0);
        for (double change : this.history) {
            if (change > largest) {
                largest = change;
            }
        }
        return largest;
    }
    public double minValue() {
        if (this.historyIsEmpty()) {
            return 0;
        }
        double smallest = this.history.get(0);
        for (double change : this.history) {
            if (change < smallest) {
                smallest = change;
            }
        }
        return smallest;
    }
    public double average() {
        if (this.historyIsEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double change : this.history) {
            sum += change;
        }
        return sum / this.history.size();
    }
    @Override
    public String toString() {
        return this.history.toString();
    }
}
