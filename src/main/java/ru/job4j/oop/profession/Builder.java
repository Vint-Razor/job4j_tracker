package ru.job4j.oop.profession;

public class Builder extends Engineer {

    private String specialization;

    public Builder(String name, String surname,
                   String education, String birthday, String specialization) {
        super(name, surname, education, birthday);
        this.specialization = specialization;
    }

    public void make() {
    }
}
