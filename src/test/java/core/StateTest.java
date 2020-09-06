package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateTest {

    @Test
    public void shouldBeEquals() {
        State s = new State("STATE");
        State s1 = new State(s.getName());

        assertEquals(s, s1);
    }
}
