package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        System.out.println(new Fact().calc(-5));
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The argument must be greater than zero");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
