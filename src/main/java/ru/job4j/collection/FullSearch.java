package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task task : list) {
            if (numbers.isEmpty()) {
                numbers.add(task.getNumber());
                continue;
            }
            for (String num : numbers) {
                if (task.getNumber().equals(num)) {
                    break;
                }
                numbers.add(task.getNumber());
            }
        }
        return numbers;
    }
}
