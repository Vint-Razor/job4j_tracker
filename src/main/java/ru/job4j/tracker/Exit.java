package ru.job4j.tracker;

public class Exit implements UserAction {
    private Output out;

    public Exit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Exit Program ===");
        return false;
    }
}
