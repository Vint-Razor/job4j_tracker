package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindNameActionTest {

    @Test
    void whenFindByNameThenSuccess() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        String sameName = "new item";
        LocalDateTime dateTime1 = LocalDateTime.of(1995, Month.AUGUST, 21, 21, 30, 0);
        tracker.add(new Item(1, sameName, dateTime1));
        LocalDateTime dateTime2 = LocalDateTime.of(1998, Month.MARCH, 10, 3, 0, 0);
        tracker.add(new Item(1, sameName, dateTime2));
        FindNameAction findNameAction = new FindNameAction(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(sameName);
        findNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ====" + ln
                        + "id: 1, name: new item, created: 21-08-1995 21:30:00" + ln
                        + "id: 2, name: new item, created: 10-03-1998 03:00:00" + ln
        );
    }

    @Test
    void whenFindByMissingNameThenNotSuccess() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        String name = "name";
        String missingName = "miss";
        LocalDateTime dateTime = LocalDateTime.of(1995, Month.AUGUST, 21, 21, 30, 0);
        tracker.add(new Item(1, name, dateTime));
        FindNameAction findNameAction = new FindNameAction(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(missingName);
        findNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ====" + ln
                        + "Заявки с именем: " + missingName + " не найдены." + ln
        );
    }
}