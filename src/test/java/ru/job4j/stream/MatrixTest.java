package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MatrixTest {

    @Test
    public void matrixToList() {
        Integer[][] matrix = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expected = Matrix.matrixToList(matrix);
        List<Integer> actual = List.of(1, 2, 3, 4);
        assertThat(expected, is(actual));
    }
}