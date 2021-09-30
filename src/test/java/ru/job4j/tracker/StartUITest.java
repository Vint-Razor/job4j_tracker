package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

public class StartUITest {
//    @Ignore
//    @Test
//    public void whenCreateItem() {
//        Input in = new StubInput(
//                new String[]{"0", "Item name", "1"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateAction(),
//                new Exit()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name"));
//    }
//    @Ignore
//    @Test
//    public void whenReplaceItem() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("Replaced item"));
//        String replacedName = "New item name";
//        Input in = new StubInput(
//                new String[] {"0", "1", replacedName, "1"}
//        );
//        UserAction[] actions = {
//                new ReplaceAction(),
//                new Exit()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
//    }
//
//    @Ignore
//    @Test
//    public void whenDeleteItem() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("Deleted item"));
//        Input in = new StubInput(
//                new String[] {"0", "1" , "1"}
//        );
//        UserAction[] actions = {
//                new DeleteAction(),
//                new Exit()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()), is(nullValue()));
//    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] action = {
                new Exit()
        };
        new StartUI(out).init(in, tracker, action);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

}