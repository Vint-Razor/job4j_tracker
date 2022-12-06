package ru.job4j.tracker;

public class CreateLargeAction implements UserAction {
    private final Output out;

    public CreateLargeAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many Items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int numOfItems = input.askInt("Enter the number of items: ");
        for (int i = 1; i <= numOfItems; i++) {
            out.println("=== Create new item ====");
            String name = ("Item " + i);
            Item item = new Item(name);
            tracker.add(item);
            out.println("Добавленная заявка: " + item);
        }
        return true;
    }
}
