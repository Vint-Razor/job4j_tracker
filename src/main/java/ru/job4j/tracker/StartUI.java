package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> action) {
        out.println("Menu.");
        for (int i = 0; i < action.size(); i++) {
            out.println(i + ". " + action.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        try {
            MemTracker tracker = new MemTracker();
            List<UserAction> actions = List.of(
                    new CreateLargeAction(output),
                    new PrintAction(output),
                    new ReplaceAction(output),
                    new DeleteAllAction(output),
                    new FindIdAction(output),
                    new FindNameAction(output),
                    new Exit(output)
            );
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
