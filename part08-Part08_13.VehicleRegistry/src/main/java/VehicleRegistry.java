import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> registry;
    // Constructor
    public VehicleRegistry() {
        this.registry = new HashMap<>();
    }
    public boolean add(LicensePlate plate, String owner) {
        if (!this.registry.containsKey(plate)) {
            this.registry.put(plate, owner);
            return true;
        }
        return false;
    }
    public String get(LicensePlate plate) {
        return this.registry.get(plate);
    }
    public boolean remove(LicensePlate plate) {
        if (this.registry.containsKey(plate)) {
            this.registry.remove(plate);
            return true;
        }
        return false;
    }
    public void printLicensePlates() {
        for (LicensePlate key : this.registry.keySet()) {
            System.out.println(key);
        }
    }

    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();
        for (String owner : this.registry.values()) {
            if (!owners.contains(owner)) {
                owners.add(owner);
                System.out.println(owner);
            }
        }
    }

}
