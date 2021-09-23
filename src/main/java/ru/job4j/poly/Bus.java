package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Let's go!");
    }

    @Override
    public void numPassengers(byte passengers) {
        System.out.println("Количество пассажиров: " + passengers);
    }

    @Override
    public float gasUp(byte gas) {
        float pay = 47.82F;
        return gas * pay;
    }

    public static void main(String[] args) {
        Bus icarus = new Bus();
        icarus.drive();
        icarus.numPassengers((byte) 22);
        System.out.println(icarus.gasUp((byte) 120));
    }
}
