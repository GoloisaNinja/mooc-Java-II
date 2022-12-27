package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean state;
    public TemperatureSensor() {
        this.state = false;
    }
    public boolean isOn() {
        return state;
    }
    public void setOn() {
        this.state = true;
    }
    public void setOff() {
        this.state = false;
    }
    public int read() {
        if (this.state) {
            int random = new Random().nextInt(61);
            return random - 30;
        }
        throw new IllegalStateException();
    }
}
