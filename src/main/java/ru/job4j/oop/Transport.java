package ru.job4j.oop;

public class Transport {
    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle subway = new Train();
        Vehicle paz = new Bus();
        Vehicle ikarus = new Bus();
        Vehicle boing = new Airplane();
        Vehicle[] transport = {train, paz, boing, subway, ikarus};
        for (Vehicle tr : transport) {
            tr.move();
        }
    }
}
