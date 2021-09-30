package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] action) {
        System.out.println("Menu:");
        for (int i = 0; i < action.length; i++) {
            System.out.println(i + ". " + action[i].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new PrintAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindIdAction(output),
                new FindNameAction(output),
                new Exit()
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
