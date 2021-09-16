package ru.job4j.oop.profession;

public class Surgeon extends Doctor {

    private int surgery;

    public Surgeon(String name, String surname, String education, String birthday, int surgery) {
        super(name, surname, education, birthday);
        this.surgery = surgery;
    }

    public void doSurgery(Pacient pacient) {
    }
}
