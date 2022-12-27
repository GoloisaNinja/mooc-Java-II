import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class Employees {
    private List<Person> employees;
    // Constructor
    public Employees() {
        this.employees = new ArrayList<>();
    }
    // Methods
    public void add(Person personToAdd) {
        this.employees.add(personToAdd);
    }
    public void add(List<Person> peopleToAdd) {
        Iterator<Person> iterator = peopleToAdd.iterator();
        while(iterator.hasNext()) {
            this.employees.add(iterator.next());
        }
    }
    public void fire(Education education) {
        Iterator<Person> iterator = this.employees.iterator();
        while(iterator.hasNext()) {
            if (iterator.next().getEducation() == education) {
                iterator.remove();
            }
        }
    }
    public void print() {
        Iterator<Person> iterator = this.employees.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    public void print(Education education) {
        Iterator<Person> iterator = this.employees.iterator();
        while(iterator.hasNext()) {
            Person employee = iterator.next();
            if (employee.getEducation() == education) {
                System.out.println(employee);
            }
        }
    }
}
