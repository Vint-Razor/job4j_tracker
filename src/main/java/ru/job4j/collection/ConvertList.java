package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        ArrayList<Integer> rsl = new ArrayList<>();
        for (int[] arr : list) {
            for (int num : arr) {
                rsl.add(num);
            }
        }
        return rsl;
    }
}
