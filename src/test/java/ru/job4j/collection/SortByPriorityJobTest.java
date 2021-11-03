package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class SortByPriorityJobTest {

    @Test
    public void when2To1ThenGreat0() {
        Job first = new Job("a", 2);
        Job second = new Job("b", 1);
        SortByPriorityJob rsl = new SortByPriorityJob();
        int exp = rsl.compare(first, second);
        assertThat(exp, greaterThan(0));
    }

    @Test
    public void when1To2ThenLess0() {
        Job first = new Job("a", 1);
        Job second = new Job("b", 2);
        SortByPriorityJob rsl = new SortByPriorityJob();
        int exp = rsl.compare(first, second);
        assertThat(exp, lessThan(0));
    }
}