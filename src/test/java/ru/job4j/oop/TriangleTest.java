package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void area() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(8, 0.001));
    }

    @Test
    public void whenAbMoreBcCaThenMinus1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 4);
        Point c = new Point(0, 2);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(-1, 0.001));
    }

    @Test
    public void whenAbMoreBcCaThenFalse() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(0, 1);
        Triangle abc = new Triangle(a, b, c);
        double ab = a.distance(b);
        double ac = a.distance(c);
        double bc = b.distance(c);
        boolean rsl = abc.exist(ab, ac, bc);
        Assert.assertFalse(rsl);
    }
}