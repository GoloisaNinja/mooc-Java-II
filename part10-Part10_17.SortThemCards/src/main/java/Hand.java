import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void add(Card card) {
        this.hand.add(card);
    }

    public void print() {
        this.hand.stream()
                 .forEach(System.out::println);
    }

    public void sort() {
        Collections.sort(this.hand);
    }
    public void sortBySuit() {
        Collections.sort(this.hand, new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand compared) {
        int handValue = this.hand.stream().
                                 map(c -> c.getValue()).
                                 reduce(0,
                                        (subTotal, currentValue) -> subTotal + currentValue);
        int comparedValue = compared.hand.stream().
                                 map(c -> c.getValue()).
                                 reduce(0,
                                        (subTotal, currentValue) -> subTotal + currentValue);
        if (handValue > comparedValue) {
            return 1;
        } else if (handValue < comparedValue) {
            return -1;
        }
        return 0;
    }
}
