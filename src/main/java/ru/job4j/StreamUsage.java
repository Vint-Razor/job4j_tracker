package ru.job4j;

import java.util.List;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spend;

        public Task(String name, long spend) {
            this.name = name;
            this.spend = spend;
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );
        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .filter(task -> task.spend > 30)
                .map(task -> task.name + " " + task.spend)
                .forEach(System.out::println);
    }
}
