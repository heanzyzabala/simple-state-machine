package core;

import java.util.ArrayList;
import java.util.List;

public class StateMachine {
    private State currentState;
    private List<Transition> transitions;
    private List<Event> postActionEvents;
    private List<Event> preActionEvents;

    public StateMachine() {
        transitions = new ArrayList<>();
        postActionEvents = new ArrayList<>();
        preActionEvents = new ArrayList<>();
    }

    public void setInitialState(State initialState) {
        this.currentState = initialState;
    }

    public void addTransition(Transition transition) {
        if(transitionExists(transition))
            throw new TransitionAlreadyExists();
        transitions.add(transition);
    }

    public void addPreActionEvent(Event e) {
        this.preActionEvents.add(e);
    }

    public void addPostActionEvent(Event e) {
        this.postActionEvents.add(e);
    }

    private boolean transitionExists(Transition transition) {
        return transitions.contains(transition);
    }

    public State next(Action action) {
        for(Transition t : transitions) {
            if(isValidTransition(action, t)) {
                for(Event e : preActionEvents) {
                    e.execute();
                }
                action.execute();
                for(Event e : postActionEvents) {
                    e.execute();
                }
                currentState = t.getToState();
                return currentState;
            }
        }
        throw new TransitionNotFound();
    }

    private boolean isValidTransition(Action action, Transition t) {
        return t.getAction().equals(action) && t.getFromState().equals(currentState);
    }

    static class TransitionNotFound extends RuntimeException {
    }

    static class TransitionAlreadyExists extends RuntimeException {
    }
}
