package core;

import java.util.ArrayList;
import java.util.List;

public class StateMachine {
    private State currentState = null;
    private final List<Transition> transitions;

    public StateMachine() {
        transitions = new ArrayList<>();
    }

    public void setInitialState(State initialState) {
        this.currentState = initialState;
    }

    public void addTransition(Transition transition) {
        if(transitionExists(transition))
            throw new TransitionAlreadyExists();
        transitions.add(transition);
    }

    private boolean transitionExists(Transition transition) {
        return transitions.contains(transition);
    }

    public State execute(Action action) {
        for (Transition t : transitions) {
            if (isValidTransition(action, t)) {
                currentState = t.getToState();
                return currentState;
            }
        }
        throw new TransitionNotFound();
    }

    private boolean isValidTransition(Action a, Transition t) {
        return t.getAction().equals(a) && t.getFromState().equals(currentState);
    }

    static class TransitionNotFound extends RuntimeException {
    }

    static class TransitionAlreadyExists extends RuntimeException {
    }
}
