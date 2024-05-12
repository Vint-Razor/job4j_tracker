package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeleteActionTest {

    @Test
    void whenItemDeletedSuccess() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("New Item"));
        DeleteAction deleteAction = new DeleteAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Delete item ====" + ln
                        + "Заявка удалена успешно." + ln
        );
    }

    @Test
    void whenItemDeletedNotSuccess() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("New Item"));
        int invalidId = -1;
        DeleteAction deleteAction = new DeleteAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(invalidId);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Delete item ====" + ln
                        + "Ошибка удаления заявки." + ln
        );
    }
}