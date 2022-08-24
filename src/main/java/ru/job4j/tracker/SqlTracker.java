package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = cn.prepareStatement(
                "INSERT INTO items (name, created) VALUES (?, ?);")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            try (ResultSet generatedKey = statement.getGeneratedKeys()) {
                if (generatedKey.next()) {
                    item.setId(generatedKey.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        try (PreparedStatement statement = cn.prepareStatement(
                "UPDATE items SET name = ?, created = ? WHERE id = ?;")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            rsl = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean deleted(int id) {
        boolean rsl = false;
        try (PreparedStatement statement = cn.prepareStatement(
                "DELETE FROM items WHERE id = ?;")) {
            statement.setInt(1, id);
            rsl = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement(
                "SELECT * FROM items;")) {
            list = saveToList(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement(
                "SELECT * FROM items WHERE name = ?;")) {
            statement.setString(1, key);
            list = saveToList(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item();
        try (PreparedStatement statement = cn.prepareStatement(
                "SELECT * FROM items WHERE id = ?;")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                item = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        timeConverter(resultSet.getTimestamp("created"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    private List<Item> saveToList(PreparedStatement statement) {
        List<Item> list = new ArrayList<>();
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            timeConverter(resultSet.getTimestamp("created"))
                    ));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static LocalDateTime timeConverter(Timestamp time) {
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        return timestamp.toLocalDateTime();
    }
}
