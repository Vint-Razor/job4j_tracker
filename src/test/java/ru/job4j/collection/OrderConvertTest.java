package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> order = new ArrayList<>();
        order.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(order);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenMoreOrder() {
        List<Order> order = new ArrayList<>();
        order.add(new Order("0001", "first"));
        order.add(new Order("0002", "second"));
        order.add(new Order("0003", "third"));
        HashMap<String, Order> map = OrderConvert.process(order);
        assertThat(map.get("0002").getNumber(), is("0002"));
    }
}