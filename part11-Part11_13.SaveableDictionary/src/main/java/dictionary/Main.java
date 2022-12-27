package dictionary;

public class Main {
    public static void main(String[] args) {
        // You can test your dictionary here
        SaveableDictionary dictionary = new SaveableDictionary("words.txt");
        boolean wasSuccessful = dictionary.load();

        if (wasSuccessful) {
            System.out.println("Successfully loaded the dictionary from file");
        }

        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("ohjelmointi"));
        System.out.println(dictionary.translate("alla oleva"));

        dictionary.add("hello", "world");
        dictionary.add("Java", "runtime");
        dictionary.add("Jetbrains", "Intellij");

        boolean saveSuccess = dictionary.save();
        if (saveSuccess) {
            System.out.println("Saved successfully!");
        }
        boolean secondLoadSuccess = dictionary.load();
        if (secondLoadSuccess) {
            System.out.println("Loaded again successfully");
        }
        System.out.println(dictionary.translate("hello"));
        System.out.println(dictionary.translate("Jetbrains"));
        System.out.println(dictionary.translate("Java"));
    }
}
