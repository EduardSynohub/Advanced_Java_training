package pl.eduard.training.collection.regex;

public class Task4 {
    public static final String REGEX_1 = "\\d+\\.\\d+";
    public static final String REGEX_2 = "[+-]?(\\d+(\\.\\d*)?|\\.\\d+)([eE][+-]?\\d+)?";
    public static final String REGEX_3 = "^((0[1-9]|[12][0-9]|3[01])/(01|03|05|07|08|10|12)|(0[1-9]|[12][0-9]|30)/(04|06|09|11)|(0[1-9]|1[0-9]|2[0-9])/02)/\\d{4}$";
        public static final String REGEX_4 = "20\\d{2}-((0[13578]|1[02])-(0[1-9]|[12]\\\\d|3[01])|(0[469]|11)-(0[1-9]|[12]\\\\d|30)|02-(0[1-9]|1\\d|2[0-9]))";

    public static void main(String[] args) {
        System.out.println("55.234234234".matches(REGEX_1));
        System.out.println("55,234234234".matches(REGEX_1));
        System.out.println("----------------");

        System.out.println("4.56E-3".matches(REGEX_2));
        System.out.println("123".matches(REGEX_2));
        System.out.println("-0.001e+4".matches(REGEX_2));
        System.out.println("abc".matches(REGEX_2));
        System.out.println("----------------");

        System.out.println("12/02/2022".matches(REGEX_3));
        System.out.println("01/02/2022".matches(REGEX_3));
        System.out.println("33/02/2022".matches(REGEX_3));
        System.out.println("12/14/2022".matches(REGEX_3));
        System.out.println("----------------");

        System.out.println("2023-01-31".matches(REGEX_4));
        System.out.println("2000-02-29".matches(REGEX_4));
        System.out.println("2024-04-30".matches(REGEX_4));
        System.out.println("2022-04-31".matches(REGEX_4));
    }
}
