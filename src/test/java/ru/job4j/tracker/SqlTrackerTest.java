package ru.job4j.tracker;

import org.junit.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemFindByGeneratedThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplaceItemThenNameReplaced() {
        final SqlTracker sqlTracker = new SqlTracker(connection);
        final Item item = sqlTracker.add(new Item("Item"));
        final Item newItem = new Item("New Item");
        sqlTracker.replace(item.getId(), newItem);
        newItem.setId(item.getId());
        assertThat(sqlTracker.findById(item.getId()), is(newItem));
    }

    @Test
    public void whenReplacedThenTrue() {
        final SqlTracker sqlTracker = new SqlTracker(connection);
        final Item item = sqlTracker.add(new Item("Item"));
        final Item newItem = new Item("New Item");
        Assert.assertTrue(sqlTracker.replace(item.getId(), newItem));
    }

    @Test
    public void whenDeletedItemThenIdIsNull() {
        final SqlTracker sqlTracker = new SqlTracker(connection);
        final Item one = sqlTracker.add(new Item("one"));
        sqlTracker.deleted(one.getId());
        assertThat(sqlTracker.findById(one.getId()), is(nullValue()));
    }

    @Test
    public void whenDeletedItemThenTrue() {
        final SqlTracker sqlTracker = new SqlTracker(connection);
        final Item one = sqlTracker.add(new Item("one"));
        Assert.assertTrue(sqlTracker.deleted(one.getId()));
    }

    @Test
    public void checkFindAll() {
        final SqlTracker sqlTracker = new SqlTracker(connection);
        final Item one = sqlTracker.add(new Item("one"));
        final Item two = sqlTracker.add(new Item("two"));
        final List<Item> expected = List.of(one, two);
        assertThat(sqlTracker.findAll(), is(expected));
    }

    @Test
    public void checkFindByName() {
        final SqlTracker sqlTracker = new SqlTracker(connection);
        final Item jackCh = sqlTracker.add(new Item("Jack"));
        final Item jackN = sqlTracker.add(new Item("Jack"));
        sqlTracker.add(new Item("Bill"));
        final List<Item> expected = List.of(jackCh, jackN);
        assertThat(sqlTracker.findByName("Jack"), is(expected));
    }

    @Test
    public void whenNotFindByNameThenEmptyList() {
        final SqlTracker sqlTracker = new SqlTracker(connection);
        assertThat(sqlTracker.findByName("Jack"), is(List.of()));
    }

    @Test
    public void checkFindById() {
        final SqlTracker sqlTracker = new SqlTracker(connection);
        sqlTracker.add(new Item("one"));
        final Item two = sqlTracker.add(new Item("two"));
        assertThat(sqlTracker.findById(two.getId()), is(two));
    }

    @Test
    public void whenNotFindByIdThenNull() {
        final SqlTracker sqlTracker = new SqlTracker(connection);
        assertThat(sqlTracker.findById(1), is(nullValue()));
    }
}