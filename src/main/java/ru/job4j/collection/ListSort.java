package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        Integer first = 8;
        Integer second = -8;
        int rsl = first.compareTo(second);
        System.out.println(rsl);
    }
}
