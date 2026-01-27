package pl.eduard.training.collection.regex;


public class Task2 {
    private static final String REGEX = "^(?=.{10,15}$)(?=.*[a-z])(?=.*[A-Z])(?!.*[a-z]{2})(?!.*[A-Z]{2}).*$";

    public static void main(String[] args) {
        System.out.println(verifyPassword("A1b@C2d#Ed"));
        System.out.println(verifyPassword("abcdefghij"));
        System.out.println(verifyPassword("ShortA1! "));
    }

    static boolean verifyPassword(String password) {
        return password.matches(REGEX);
    }
}
