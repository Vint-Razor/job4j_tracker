package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var person = phones.find("Petr");
        assertThat(person.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenNotFoundByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var person = phones.find("Igor");
        var expected = new ArrayList<>();
        assertThat(person, is(expected));
    }
}