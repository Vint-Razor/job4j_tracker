package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;

public class SortDescByNameJobTest {

    @Test
    public void compare() {
        Job first = new Job("a", 2);
        Job second = new Job("b", 1);
        SortDescByNameJob rsl = new SortDescByNameJob();
        int exp = rsl.compare(first, second);
        assertThat(exp, greaterThan(0));
    }

    @Test
    public void whenNamesEqualThen0() {
        Job first = new Job("b", 2);
        Job second = new Job("b", 1);
        SortDescByNameJob rsl = new SortDescByNameJob();
        int exp = rsl.compare(first, second);
        assertEquals(exp, 0);
    }
}