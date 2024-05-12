package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindIdActionTest {

    @Test
    void whenFindIdThenSuccess() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        LocalDateTime dateTime = LocalDateTime.of(1995, Month.AUGUST, 21, 21, 30, 0);
        Item item = tracker.add(new Item(1, "new item", dateTime));
        FindIdAction findIdAction = new FindIdAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        findIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ====" + ln
                        + "id: 1, name: new item, created: 21-08-1995 21:30:00" + ln
        );
    }

    @Test
    void whenFindIdThenNotSuccess() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        FindIdAction findIdAction = new FindIdAction(output);
        Input input = mock(Input.class);
        findIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ====" + ln
                        + "Заявка с введенным id: 0 не найдена." + ln
        );
    }
}