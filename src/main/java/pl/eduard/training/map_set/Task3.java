package pl.eduard.training.map_set;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Map<String, Country> countryMap = getMap(initialize());
        Set<String> keys = countryMap.keySet();

        for (String key : keys) {
            System.out.println(countryMap.get(key).getName() + " - " + countryMap.get(key).getCapital());
        }
    }

    public static List<Country> initialize (){
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("France", "Paris"));
        countries.add(new Country("Germany", "Berlin"));
        countries.add(new Country("Italy", "Rome"));
        countries.add(new Country("Spain", "Madrid"));
        countries.add(new Country("Poland", "Warsaw"));

        return countries;
    }

    public static Map<String, Country> getMap (List<Country> list) {
        Map<String, Country> countryMap = new HashMap<>();

        for (Country c : list) {
            countryMap.put(c.getCapital(), c);
        }

        return countryMap;
    }
}
