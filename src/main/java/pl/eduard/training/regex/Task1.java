package pl.eduard.training.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    private static final String REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    public static void main(String[] args) {
        System.out.println(verifyEmail("test@example.com"));
        System.out.println(verifyEmail("john.doe@gmail.com"));
        System.out.println(verifyEmail("test@com"));
        System.out.println(verifyEmail("@domain.com"));
    }

    static boolean verifyEmail(String email) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
