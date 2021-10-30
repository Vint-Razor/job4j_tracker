package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> user = new HashMap<>();
        user.put("dany@mail.ru", "Den Braun");
        user.put("fred@mail.ru", "Freddy Krueger");
        user.put("robocop@mail.ru", "Alex Murphy");
        user.put("fred@mail.ru", "Freddie Mercury");
        for (String key : user.keySet()) {
            System.out.println(key + " = " + user.get(key));
        }
    }
}
