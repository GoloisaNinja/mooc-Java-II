import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> list;
    // Constructor
    public TodoList() {
        this.list = new ArrayList<>();
    }
    public void add(String task) {
        this.list.add(task);
    }
    public void remove(int taskPosition) {
        int index = taskPosition - 1;
        if (this.list.size() >= taskPosition) {
            this.list.remove(index);
        }
    }
    public void print() {
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println((i + 1) + ": " + this.list.get(i));
        }
    }
}
