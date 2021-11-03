package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] splitL = left.split(". ");
        String[] splitR = right.split(". ");
        int digitL = Integer.parseInt(splitL[0]);
        int digitR = Integer.parseInt(splitR[0]);
        return Integer.compare(digitL, digitR);
    }
}
