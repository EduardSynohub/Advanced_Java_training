package pl.eduard.training.regex;

public class Task5 {
    public static final String LOGIN_REGEX = "^[a-zA-Z_-][a-zA-Z0-9_-]{4,}$";
    static boolean verifyLogin(String login) {
        return login.matches(LOGIN_REGEX);
    }
}
