package ru.job4j.tracker;

public class CreateLargeAction implements UserAction {
    private final Output out;

    public CreateLargeAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        for (int i = 0; i < 1_000_000; i++) {
            out.println("=== Create new item ====");
            String name = ("Item " + i);
            Item item = new Item(name);
            tracker.add(item);
            out.println("Добавленная заявка: " + item);
        }
        return true;
    }
}
