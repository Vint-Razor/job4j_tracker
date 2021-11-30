package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Возвращает список всех пользователей, которые содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> name = s -> s.getName().contains(key);
        Predicate<Person> address = s -> s.getAddress().contains(key);
        Predicate<Person> phone = s -> s.getPhone().contains(key);
        Predicate<Person> surname = s -> s.getSurname().contains(key);
        Predicate<Person> combine = name.or(address.or(phone.or(surname)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
