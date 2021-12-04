package ru.job4j.stream;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.List;

public class MatrixTest {

    @Test
    public void matrixToList() {
        List<List<Integer>> matrix = List.of(
            List.of(1, 2),
            List.of(3, 4)
        );
        List<Integer> expected = Matrix.matrixToList(matrix);
        List<Integer> actual = List.of(1, 2, 3, 4);
        assertThat(expected, is(actual));
    }
}