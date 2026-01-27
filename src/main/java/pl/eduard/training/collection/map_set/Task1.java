package pl.eduard.training.collection.map_set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> stringSet = new HashSet<>();
        int count = 0;

        System.out.println("Please enter any text. If you want close the program write \"exit\":");
        String s = scanner.nextLine();

        while (!s.equalsIgnoreCase("exit")) {
            stringSet.add(s);
            System.out.println("Please enter any text. If you want close the program write 'exit': ");
            s = scanner.nextLine();
            count++;
        }

        System.out.println("Provided strings: " + count + ", Collection size: " + stringSet.size());
    }
}
