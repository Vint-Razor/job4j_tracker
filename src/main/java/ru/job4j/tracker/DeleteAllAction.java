package ru.job4j.tracker;

public class DeleteAllAction implements UserAction {
    private Output out;

    public DeleteAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete All Items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        for (int i = 0; i < 1_000_000; i++) {
            out.println("=== Delete item ====");
            int id = i;
            if (tracker.deleted(id)) {
                out.println("Заявка удалена успешно.");
            } else {
                out.println("Ошибка удаления заявки.");
            }
        }

        return true;
    }
}
