package pl.eduard.training.map_set;

import pl.eduard.training.collection.Person;
import pl.eduard.training.collection.Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task7 {
    public static void main(String[] args) {
        Map<Integer, List<Person>> peopleByAge = new TreeMap<>();

        for (Person p : Task5.filteredPeople()) {

            if (!peopleByAge.containsKey(p.getAge())) {
                List<Person> peopleWithSameAge = new ArrayList<>();
                peopleWithSameAge.add(p);
                peopleByAge.put(p.getAge(), peopleWithSameAge);
            } else {
                peopleByAge.get(p.getAge()).add(p);
                peopleByAge.put(p.getAge(), peopleByAge.get(p.getAge()));
            }
        }

        for (Map.Entry<Integer, List<Person>> entry : peopleByAge.entrySet()) {
            System.out.println("People with age " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
