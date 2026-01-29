package pl.eduard.training.collection.regex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Task3 {
    private static final String REGEX = "^\\s*\\d+(?:\\s*[+\\-*/]\\s*\\d+)*\\s*=\\s*\\d+\\s*";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a mathematical equations. If you want exit - enter 'quit': ");
        String input = scanner.nextLine().replaceAll(" ", "");

        while (!input.equalsIgnoreCase("quit")) {
            System.out.println("Please enter a mathematical equation. If you want exit - enter 'quit': ");
            if (checkEquation(input)){
                addEquationToFile(input);
            }
            input = scanner.nextLine().replaceAll(" ", "");
        }
    }

    public static boolean checkEquation(String equationToCheck) {
        return equationToCheck.matches(REGEX);
    }

    public static void addEquationToFile(String equationToWrite) {
        Path path = Paths.get("operations.txt");

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("Creating file error: " + e.getMessage());
            }
        }

        try {
            Files.writeString(path, equationToWrite, StandardOpenOption.APPEND);
            Files.writeString(path, "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Write text to file error: " + e.getMessage());
        }
    }
}
