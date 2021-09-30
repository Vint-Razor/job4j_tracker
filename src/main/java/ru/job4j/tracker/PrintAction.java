package ru.job4j.tracker;

public class PrintAction implements UserAction {
    private Output out;

    public PrintAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Print all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
