package pl.eduard.training.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        removeDivider(numbers, 2);
        System.out.println(numbers);
    }

    public static void removeDivider (List<Integer> list, int divider) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();

            if (number % divider == 0) {
                iterator.remove();
            }
        }
    }
}
