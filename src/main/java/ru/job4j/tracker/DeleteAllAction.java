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
        for (var item : tracker.findAll()) {
            int numOfItem = item.getId();
            if (tracker.deleted(numOfItem)) {
                out.println("Заявка удалена успешно. " + numOfItem);
            } else {
                out.println("Ошибка удаления заявки.");
            }
        }
        return true;
    }
}
