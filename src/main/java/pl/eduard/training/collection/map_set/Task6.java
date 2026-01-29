package pl.eduard.training.collection.map_set;

import java.util.Map;

public class Task6 {
    public static void main(String[] args) {
        Map<Integer, Integer> randomMap = GenerateRandom.checkRand(100, 10000);
        for (Map.Entry<Integer, Integer> entry : randomMap.entrySet()) {
            System.out.println("Key: '" + entry.getKey() + "', value: '" + entry.getValue() + "'.");
        }
    }
}
