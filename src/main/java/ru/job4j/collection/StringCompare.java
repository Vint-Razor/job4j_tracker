package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int size = left.length() < right.length() ? left.length() : right.length();
        int rsl = 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (left.charAt(i) > right.charAt(i)) {
                return 1;
            } else if (left.charAt(i) < right.charAt(i)) {
                return -1;
            }
            count++;
        }
        if (left.length() > count) {
            return 1;
        } else if (right.length() > count) {
            return -1;
        }
        return rsl;
    }

    public static void main(String[] args) {
        StringCompare srtCom = new StringCompare();
        String one = "ivan";
        String two = "ivanov";
        int rsl = srtCom.compare(one, two);
        System.out.println(rsl);
    }
}
