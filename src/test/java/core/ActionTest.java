package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ActionTest {

    @Test
    public void shouldPass() {
        Action action = new Action();
        action.setName("action1");
        action.setEvent(() -> assertTrue(true));
        assertEquals("action1", action.getName());
        action.execute();
    }
}
