package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item ivanov = new Item(1, "Ivanov");
        System.out.println(ivanov);
    }
}
