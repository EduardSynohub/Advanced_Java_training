package pl.eduard.training.collection.list;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<City> cities = initialize();
        for (City c : cities) {
            System.out.println(c);
        }

        System.out.println("-------------------------------");

        List<City> subList = firstSubList(cities, 2, 3);
        for (City c : subList) {
            System.out.println(c);
        }

        System.out.println("-------------------------------");

        List<City> secondSubList = secondSubList(cities, 2, 10);
        for (City c : secondSubList) {
            System.out.println(c);
        }
    }

    public static List<City> initialize() {
        List<City> cities = new ArrayList<>();

        cities.add(new City("New York", 8419000));
        cities.add(new City("Los Angeles", 3980000));
        cities.add(new City("Chicago", 2716000));
        cities.add(new City("Houston", 2328000));
        cities.add(new City("Phoenix", 1690000));

        return cities;
    }

    public static List<City> firstSubList(List<City> list, int start, int end ) {
        if (end < list.size()) {
            return list.subList(start, end + 1);
        }
        return list.subList(start, list.size());
    }

    public static List<City> secondSubList(List<City> list, int start, int end ) {
        List<City> subList = new ArrayList<>();

        for (int i = start; i <= end && i < list.size(); i++) {
            subList.add(list.get(i));
        }

        return subList;
    }
}
