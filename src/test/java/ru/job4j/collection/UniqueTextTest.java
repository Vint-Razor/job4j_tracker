package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

public class UniqueTextTest {

    @Test
    public void isEquals() {
        String origin = "My cat eats a mouse and milk";
        String text = "My cat eats milk and a mouse";
        Assert.assertTrue(UniqueText.isEquals(origin, text));
    }

    @Test
    public void isNotEquals() {
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        Assert.assertFalse(UniqueText.isEquals(origin, text));
    }
}