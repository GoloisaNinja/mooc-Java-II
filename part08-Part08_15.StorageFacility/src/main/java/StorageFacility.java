import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> storageMall;
    // Constructor
    public StorageFacility() {
        this.storageMall = new HashMap<>();
    }
    public void add(String unit, String item) {
        if (!this.storageMall.containsKey(unit)) {
            this.storageMall.putIfAbsent(unit, new ArrayList<>());
        }
        this.storageMall.get(unit).add(item);
    }
    public void remove(String unit, String item) {
       if (this.unitExists(unit)) {
           ArrayList<String> contents = this.storageMall.get(unit);
           contents.remove(item);
           if (contents.size() == 0) {
               this.storageMall.remove(unit);
           }
       }
    }
    public ArrayList<String> contents(String unit) {
        if (this.storageMall.containsKey(unit)) {
            return this.storageMall.get(unit);
        } else {
            return new ArrayList<>();
        }
    }
    private boolean unitExists(String unit) {
        return this.storageMall.containsKey(unit);
    }
    public ArrayList<String> storageUnits() {
        ArrayList<String> units = new ArrayList<>();
        for (String key : this.storageMall.keySet()) {
            ArrayList<String> contents = this.storageMall.get(key);
            if (contents.size() > 0) {
                units.add(key);
            }
        }
        return units;
    }
}
