package ru.job4j.oop.profession;

public class Engineer extends Profession {

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Solution development(Task task) {
        return new Solution();
    }
}
