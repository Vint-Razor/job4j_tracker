package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(123, 32, -287, 3, -9, 0);
        List<Integer> rsl = nums.stream()
                .filter(num -> num >= 0)
                .collect(Collectors.toList());
        rsl.forEach(System.out::println);
    }
}
