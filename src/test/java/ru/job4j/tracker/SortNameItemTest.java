package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SortNameItemTest {

    @Test
    public void whenSortName() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("b");
        Item item2 = new Item("c");
        Item item3 = new Item("a");
        Item item4 = new Item("d");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        List<Item> expected = List.of(item3, item1, item2, item4);
        Collections.sort(items, new SortNameItem());
        assertThat(items, is(expected));
    }
}