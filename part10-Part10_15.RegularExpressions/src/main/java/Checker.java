

public class Checker {
    public boolean isDayOfWeek(String str) {
        String regex = "mon|tue|wed|thu|fri|sat|sun";
        return str.matches(regex);
    }
    public boolean allVowels(String str) {
        String regex = "(a|e|i|o|u)+";
        return str.matches(regex);
    }
    public boolean timeOfDay(String str) {
        String regex = "([0-1][0-9]|2[0-3])(:[0-5][0-9]){2}|2[0-4]:00:00";
        return str.matches(regex);
    }
}
