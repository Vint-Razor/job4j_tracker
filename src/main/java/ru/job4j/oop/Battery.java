package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        this.load += another.load;
        another.load = 0;
    }

    public void comparator(Battery second) {
        System.out.println(
                "Первая батарея:" + this.load
                        + "% вторая батарея:" + second.load + "%"
        );
    }

    public static void main(String[] args) {
        Battery first = new Battery(33);
        Battery second = new Battery(50);
        first.comparator(second);
        first.exchange(second);
        first.comparator(second);
    }
}
