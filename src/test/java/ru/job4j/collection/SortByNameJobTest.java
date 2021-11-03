package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class SortByNameJobTest {

    @Test
    public void compare() {
        Job first = new Job("a", 2);
        Job second = new Job("b", 1);
        SortByNameJob rsl = new SortByNameJob();
        int exp = rsl.compare(first, second);
        assertThat(exp, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Job first = new Job("a", 2);
        Job second = new Job("b", 1);
        Comparator<Job> rsl = new SortByNameJob().thenComparing(new SortByPriorityJob());
        int exp = rsl.compare(first, second);
        assertThat(exp, lessThan(0));
    }

    @Test
    public void whenNamesEqualAndPriority() {
        Job first = new Job("a", 2);
        Job second = new Job("a", 1);
        Comparator<Job> rsl = new SortByNameJob().thenComparing(new SortByPriorityJob());
        int exp = rsl.compare(first, second);
        assertThat(exp, greaterThan(0));
    }
}