package application;
import java.util.ArrayList;
import java.util.List;
public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readings;
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    public boolean isOn() {
        for (Sensor sensor : this.sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }
    public void setOff() {
        for (Sensor sensor : this.sensors) {
            sensor.setOff();
        }
    }
    public void setOn() {
        for (Sensor sensor : this.sensors) {
            sensor.setOn();
        }
    }
    public int read() {
        if (this.sensors.isEmpty() || !this.isOn()) {
            throw new IllegalStateException();
        }
        int sum = 0;
        int count = this.sensors.size();
        for (Sensor sensor : this.sensors) {
            int reading = sensor.read();
            sum += reading;

        }
        int avg = sum / count;
        readings.add(avg);
        return avg;
    }
    public List<Integer> readings() {
        return this.readings;
    }
}
