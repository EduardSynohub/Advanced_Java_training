package pl.eduard.training.maven;

import com.google.common.collect.Lists;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
//        Guava dependency
        List<String> names = Lists.newArrayList("John", "David", "Den");
        List<String> reversed = Lists.reverse(names);
        System.out.println(reversed);
    }
}
