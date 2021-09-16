package ru.job4j.oop.profession;

public class Dentist extends Doctor {

    private int teeth;

    public Dentist(String name, String surname, String education, String birthday, int teeth) {
        super(name, surname, education, birthday);
        this.teeth = teeth;
    }

    public void pullingTooth(Pacient pacient) {
    }
}
