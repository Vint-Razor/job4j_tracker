package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public static List<Integer> matrixToList(List<List<Integer>> matrix) {
        return Stream.of(matrix)
                .flatMap(List::stream)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
