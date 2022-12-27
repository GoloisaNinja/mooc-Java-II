package application;

public class StandardSensor implements Sensor {
    private int reading;
    public StandardSensor(int reading) {
        this.reading = reading;
    }
    public void setOn() {};
    public void setOff() {};
    public boolean isOn() {
        return true;
    }

    public int read() {
        return this.reading;
    }
}
