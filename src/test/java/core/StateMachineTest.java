package core;

import core.fixtures.LogEvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateMachineTest {

    private StateMachine stateMachine;

    private State initial;
    private State next;
    private State next1;
    private State last;

    private Action a1;
    private Action a2;
    private Action a3;
    private Action invalid = new ActionBuilder()
            .name("invalid")
            .build();

    private Transition t1;
    private Transition t2;
    private Transition t3;

    @Before
    public void before() {
        initial = new State("INITIAL");
        next = new State("NEXT");
        next1 = new State("NEXT1");
        last = new State("LAST");

        a1 = new ActionBuilder()
                .name("action1")
                .event(new LogEvent())
                .build();
        a2 = new ActionBuilder()
                .name("action1")
                .build();
        a3 = new ActionBuilder()
                .name("action1")
                .build();

        t1 = new TransitionBuilder()
                .name("transition1")
                .from(initial)
                .action(a1)
                .to(next)
                .build();

        t2 = new TransitionBuilder()
                .name("transition2")
                .from(next)
                .action(a2)
                .to(next1)
                .build();

        t3 = new TransitionBuilder()
                .name("transition3")
                .from(next1)
                .action(a3)
                .to(last)
                .build();

        stateMachine = new StateMachineBuilder()
                .initialState(initial)
                .addTransition(t1)
                .addTransition(t2)
                .addTransition(t3)
                .build();
    }

    @Test(expected = StateMachine.TransitionNotFound.class)
    public void shouldThrowTransitionNotFound() {
        State actual = stateMachine.next(a1);
        assertEquals(new State("NEXT"), actual);
        stateMachine.next(invalid);
    }

    @Test
    public void shouldExecutePreActionEvent() {
        State opened = new State("OPENED");
        State closed = new State("CLOSED");

        Action close = new ActionBuilder()
                .name("close")
                .event(() -> System.out.println("close"))
                .build();

        Action open = new ActionBuilder()
                .name("open")
                .event(() -> System.out.println("open"))
                .build();

        Transition openedToClosed = new TransitionBuilder()
                .name("openedToClosed")
                .from(opened)
                .action(close)
                .to(closed)
                .build();

        Transition closedToOpen = new TransitionBuilder()
                .name("closedToOpen")
                .from(closed)
                .action(open)
                .to(opened)
                .build();

        StateMachine stateMachine = new StateMachineBuilder()
                .initialState(opened)
                .addPreActionEvent(() -> System.out.println("pre action"))
                .addTransition(openedToClosed)
                .addTransition(closedToOpen)
                .addPostActionEvent(() -> System.out.println("post action"))
                .build();

        stateMachine.next(close);
        stateMachine.next(open);
    }

    @Test(expected = StateMachine.TransitionAlreadyExists.class)
    public void shouldThrowTransitionAlreadyExists() {
        stateMachine.addTransition(t1);
    }

    @Test
    public void shouldPass() {
        State actual = stateMachine.next(a1);
        assertEquals(next, actual);

        actual = stateMachine.next(a1);
        assertEquals(next1, actual);

        actual = stateMachine.next(a1);
        assertEquals(last, actual);
    }

    @Test
    public void shouldInvokeEvent() {
        a1.setEvent(() -> Assert.assertTrue(true));
        stateMachine.next(a1);
    }
}
