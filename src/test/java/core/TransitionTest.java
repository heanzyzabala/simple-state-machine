package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransitionTest {

    @Test
    public void shouldBeEquals() {
        State s1 = new State("STATE_1");
        State s2 = new State("STATE_2");

        Action a = new ActionBuilder()
                .name("ACTION")
                .build();

        Transition t = new TransitionBuilder()
                .name("TRANSITION")
                .action(a)
                .from(s1)
                .to(s2)
                .build();

        Transition t1 = new TransitionBuilder()
                .name(t.getName())
                .action(a)
                .from(s1)
                .to(s2)
                .build();

        assertEquals(t, t1);
    }
}
