package pl.eduard.training.map_set;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCorrectAnswers = 0;

        Map<String, String> opposites = getMap();
        Set<String> keys = opposites.keySet();

        for (String key : keys) {
            System.out.println("What is the opposite for \"" + key + "\":");
            String s = scanner.nextLine();

            if (s.equalsIgnoreCase(opposites.get(key))) {
                countCorrectAnswers++;
            }
        }

        System.out.println("Correct answers: " + countCorrectAnswers);
    }

    public static Map<String, String> getMap() {
        Map<String, String> opposites = new HashMap<>();
        opposites.put("big", "small");
        opposites.put("hot", "cold");
        opposites.put("fast", "slow");
        opposites.put("happy", "sad");
        opposites.put("strong", "weak");

        return opposites;
    }
}
