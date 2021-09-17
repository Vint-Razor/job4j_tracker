package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student ivanov = new Student();
        ivanov.setFullName("Ivanov Sergey Andreevich");
        ivanov.setGroup("Computer science");
        ivanov.setAdmission(LocalDate.now());

        System.out.println("Full name: " + ivanov.getFullName() + System.lineSeparator()
                + "group: " + ivanov.getGroup() + System.lineSeparator()
                + "date of admission: " + ivanov.getAdmission());
    }
}
