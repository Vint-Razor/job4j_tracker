package ru.job4j.tracker;

import java.util.List;

public class FindNameAction implements UserAction {
    private Output out;

    public FindNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by name items";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        List<Item> items = memTracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
