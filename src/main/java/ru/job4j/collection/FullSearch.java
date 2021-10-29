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
            if (!myContain(numbers, task)) {
                numbers.add(task.getNumber());
            }
        }
        return numbers;
    }

    private static boolean myContain(HashSet<String> arr, Task task) {
        boolean flag = false;
        for (String num : arr) {
            if (task.getNumber().equals(num)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
