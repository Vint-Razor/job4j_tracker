package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        System.out.println(new Fact().calc(-5));
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The argument cannot be less than zero.");
        }
        if (n < 2) {
            return n;
        }
        int rsl = 1;
        for (int index = 2; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
