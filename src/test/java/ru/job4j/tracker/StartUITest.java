package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answer = {"Testing"};
        Input input = new StubInput(answer);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Testing");
        assertThat(created.getName(), is(expected.getName()));
    }
}