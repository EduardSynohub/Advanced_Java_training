package pl.eduard.training.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Task4 {
    public static void main(String[] args) {
        List<City> cities = Task3.initialize();

        for (City c : cities) {
            System.out.println(c);
        }

        System.out.println("----------------------------------");
        List<City> reversedCities = reverse(cities);

        for (City c : reversedCities) {
            System.out.println(c);
        }
    }

    public static List<City> reverse (List<City> list ) {
        List<City> reversedList = new ArrayList<>();

        ListIterator<City> iterator = list.listIterator(list.size());

        while (iterator.hasPrevious()) {
            reversedList.add(iterator.previous());
        }

        return reversedList;
    }
}
