package pl.eduard.training.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>();

        for (int i = 10; i <= 19; i++) {
            elements.add(i);
        }

        System.out.println("----------1----------");

        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i));
        }

        System.out.println("----------2----------");

        Iterator<Integer> integerIterator = elements.iterator();

        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }

        System.out.println("----------3----------");

        for (Iterator<Integer> iterator = elements.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }

        System.out.println("----------4----------");

        for (int i : elements) {
            System.out.println(i);
        }
    }
}
