package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NotifyAccountTest {

    @Test
    public void whenNoRepeatsThenSource() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3232f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3232f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void whenRepeatsThenModified() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Ivan Ivanov", "eDer3232f"),
                new Account("142", "Ivan Ivanov", "0rBnMm876"),
                new Account("123", "Ivan Ivanov", "Bvg690RfdD"),
                new Account("532", "Ivan Ivanov", "GhJu0043f")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Ivan Ivanov", "eDer3232f"),
                        new Account("142", "Ivan Ivanov", "0rBnMm876"),
                        new Account("532", "Ivan Ivanov", "GhJu0043f")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}