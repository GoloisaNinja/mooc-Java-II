import java.util.ArrayList;
import java.util.List;

public class MainProgram {

    public static void main(String[] args) {
        // test your classes here
        Person anna = new Person("Anna", Education.PHD);
//        Person david = new Person("David", Education.BA);
//        Person jack = new Person("Jack", Education.HS);
//        Person loulou = new Person("Lou Lou", Education.BA);

//        List<Person> tempList = new ArrayList<>();
//        tempList.add(jack);
//        tempList.add(loulou);

        Employees employees = new Employees();
        employees.add(anna);
//        employees.add(david);
//        employees.add(tempList);
        employees.fire(Education.PHD);

        employees.print();
//        System.out.println("-------------------------");
//        employees.print(Education.BA);
//        System.out.println("----------POST FIRING---------");
//        employees.fire(Education.HS);
//        employees.print();

    }
}
