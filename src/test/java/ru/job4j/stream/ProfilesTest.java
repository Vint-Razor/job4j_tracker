package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ProfilesTest {

    @Test
    public void collect() {
        Address address1 = new Address("Moscow", "Lenina", "12", 23);
        Address address2 = new Address("Kukuevo", "Octyabrya", "3", 1);
        List<Profile> profs = Arrays.asList(
                new Profile(address1),
                new Profile(address2)
        );
        Profiles profiles = new Profiles();
        List<Address> expected = profiles.collect(profs);
        List<Address> actual = Arrays.asList(address1, address2);
        assertThat(expected, is(actual));
    }
}