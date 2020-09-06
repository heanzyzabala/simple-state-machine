package core;

import org.junit.Test;

import static core.StateMachine.*;
import static core.StateMachine.TransitionNotFound;
import static org.junit.Assert.assertEquals;

public class StateMachineTest {

    @Test(expected = TransitionAlreadyExists.class)
    public void shouldThrowTransitionAlreadyExists() {
        State s1 = new State("STATE_1");
        State s2 = new State("STATE_1");

        Action a = new ActionBuilder()
                .name("ACTION")
                .build();

        Transition t = new TransitionBuilder()
                .name("TRANSITION")
                .action(a)
                .from(s1)
                .to(s2)
                .build();

        new StateMachineBuilder()
                .addTransition(t)
                .addTransition(t)
                .build();
    }

    @Test(expected = TransitionNotFound.class)
    public void shouldThrowTransitionNotFound() {
        State s1 = new State("STATE_1");
        State s2 = new State("STATE_1");

        Action a = new ActionBuilder()
                .name("ACTION")
                .build();

        Transition t = new TransitionBuilder()
                .name("TRANSITION")
                .action(a)
                .from(s1)
                .to(s2)
                .build();

        StateMachine sm = new StateMachineBuilder()
                .initialState(null)
                .addTransition(t)
                .build();

        sm.execute(a);
    }

    @Test
    public void shouldMoveTransition() {
        State s1 = new State("STATE_1");
        State s2 = new State("STATE_2");

        Action a = new ActionBuilder()
                .name("ACTION")
                .build();

        Transition t = new TransitionBuilder()
                .name("TRANSITION_1")
                .action(a)
                .from(s1)
                .to(s2)
                .build();

        Action a1 = new ActionBuilder()
                .name("ACTION_1")
                .build();

        Transition t1 = new TransitionBuilder()
                .name("TRANSITION_2")
                .action(a1)
                .from(s2)
                .to(s1)
                .build();

        StateMachine sm = new StateMachineBuilder()
                .initialState(s1)
                .addTransition(t)
                .addTransition(t1)
                .build();

        State currentState = sm.execute(a);
        assertEquals(s2, currentState);

        currentState = sm.execute(a1);
        assertEquals(s1, currentState);
    }
}
