import java.util.ArrayList;
import java.util.List;
public class Herd implements Movable {

    private List<Movable> members;
    // Constructor
    public Herd() {
        this.members = new ArrayList<>();
    }
    public void addToHerd(Movable movable) {
        this.members.add(movable);
    }
    public void move(int dx, int dy) {
        if (this.members.isEmpty()) {
            return;
        }
        for (Movable member : this.members) {
            member.move(dx, dy);
        }
    }
    public String toString() {
        String returnString = "";
        int loop = 0;
        for (Movable member : this.members) {
            returnString += member.toString();
            if (loop != this.members.size() -1) {
                returnString += "\n";
            }
        }
        return returnString;
    }
}
