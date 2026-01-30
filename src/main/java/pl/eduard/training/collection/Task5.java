package pl.eduard.training.collection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Task5 {
    public static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    public static final String ONLY_LETTERS_REGEX = "^[A-Z][a-z]*$";
    public static final String INTEGER_AGE_REGEX = "^([1-9][0-9]?){1}$";
    public static List<Person> filteredPeople() {
        Path path = Paths.get("files/people.csv");
        List<Person> people = new ArrayList<>();

        if (!Files.exists(path)) {
            System.out.println("File doesnt exist.");
            System.exit(0);
        }

        try {
            for (String line : Files.readAllLines(path)) {
                if (line.split(",")[0].matches(EMAIL_REGEX) &&
                        line.split(",")[1].matches(ONLY_LETTERS_REGEX) &&
                        line.split(",")[2].matches(ONLY_LETTERS_REGEX) &&
                        line.split(",")[3].matches(INTEGER_AGE_REGEX) &&
                        line.split(",")[4].matches(ONLY_LETTERS_REGEX)) {
                    people.add(
                            new Person((line.split(",")[1]),
                                    line.split(",")[2],
                                    Integer.parseInt(line.split(",")[3]),
                                    line.split(",")[4])
                    );
                }
            }
        } catch (IOException e) {
            System.out.println("Reading file error: " + e.getMessage());
        }

        return people;
    }
}
