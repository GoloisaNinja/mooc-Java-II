

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        Checker checker = new Checker();
        boolean check1 = checker.isDayOfWeek("fri");
        System.out.println(check1);
        boolean check2 = checker.allVowels("aeooouiiiii");
        System.out.println(check2);
        boolean check3 = checker.timeOfDay("24:00:01");
        System.out.println(check3);
    }
}
