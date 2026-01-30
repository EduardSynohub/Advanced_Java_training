package pl.eduard.training.map_set;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            System.out.println("Please enter a number in interval from 0 to 9: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid number! Try again: ");
                scanner.next();
            }
            int number = scanner.nextInt();
            numbers.add(number);
        }

        List<Integer> copiedNumbers = List.copyOf(numbers);
        System.out.println(copiedNumbers);

        numbers.sort(null);
        System.out.println(numbers);
    }
}
