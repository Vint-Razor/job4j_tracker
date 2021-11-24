package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        String[] arr1 = first.split("/");
        String[] arr2 = second.split("/");
        int rsl = arr2[0].compareTo(arr1[0]);
        return rsl == 0 ?  first.compareTo(second) : rsl;
    }

}
