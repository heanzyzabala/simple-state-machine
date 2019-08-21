package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateTest {

    @Test
    public void shouldPass() {
        State state = new State("INITIAL");
        assertEquals("INITIAL", state.getName());
    }
}
