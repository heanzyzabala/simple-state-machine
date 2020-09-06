package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ActionTest {

    @Test
    public void shouldBeEqual() {
        Action a = new Action();
        a.setName("ACTION");

        Action a1 = new Action();
        a1.setName(a.getName());

        assertEquals(a, a1);
    }
}
