package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransitionTest {

    @Test
    public void shouldPass() {
        State from = new State("FROM");
        State to = new State("TO");
        Action action = new Action();
        action.setName("action");
        Transition transition = new Transition();
        transition.setName("t1");
        transition.setFromState(from);
        transition.setAction(action);
        transition.setToState(to);

        assertEquals("t1", transition.getName());
        assertEquals(from, transition.getFromState());
        assertEquals(action, transition.getAction());
        assertEquals(to, transition.getToState());
    }
}
