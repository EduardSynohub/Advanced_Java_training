package pl.eduard.training.collection.map_set;

import java.util.HashSet;
import java.util.Set;

public class Task5 {
    public static void main(String[] args) {
        Set<String> mastersOne = Set.of("Master Shifu", "Grand Master Oogway", "Master Tigress");
        Set<String> mastersTwo = Set.of("Master Viper", "Master Mantis", "Master Crane");
        Set<String> allMasters = new HashSet<>();

        allMasters.addAll(mastersOne);
        allMasters.addAll(mastersTwo);

        System.out.println(allMasters);
    }
}
