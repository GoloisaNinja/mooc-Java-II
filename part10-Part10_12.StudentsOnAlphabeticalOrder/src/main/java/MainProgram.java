import java.util.ArrayList;
import java.util.Collections;

public class MainProgram {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Student second = new Student("jamo1");
        Student first = new Student("jamo");
        Student third = new Student("alfie");
        System.out.println(first.compareTo(third));
        students.add(first);
        students.add(second);
        students.add(third);
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
