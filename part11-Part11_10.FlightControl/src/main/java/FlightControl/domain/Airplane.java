package FlightControl.domain;

public class Airplane {
    private String ID;
    private int capacity;
    public Airplane(String id, int capacity) {
        this.ID = id;
        this.capacity = capacity;
    }
    public String getName() {
        return this.ID;
    }
    public String getID() {
        return this.ID;
    }
    @Override
    public String toString() {
        return this.ID + " (" + this.capacity + " capacity)";
    }
}
