package pl.eduard.training.collection.map_set;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class GenerateRandom {
    public static Map<Integer, Integer> checkRand(int amount, int interval) {
        Random random = new Random();
        Map<Integer, Integer> numbersMap = new TreeMap<>();

        for (int i = 0; i < amount; i++) {
            int randomNumber = random.nextInt(1, interval+ 1);

            if (!numbersMap.containsKey(randomNumber)) {
                numbersMap.put(randomNumber, 1);
            } else {
                for (Integer key : numbersMap.keySet()) {
                    if (key == randomNumber) {
                        numbersMap.put(randomNumber, (numbersMap.get(randomNumber) + 1));
                    }
                }
            }
        }

        return numbersMap;
    }
}
