package core;

public class Transition {
    private String name;
    private State fromState;
    private Action action;
    private State toState;

    public void setName(String name) {
        this.name = name;
    }

    public void setFromState(State fromState) {
        this.fromState = fromState;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setToState(State toState) {
        this.toState = toState;
    }

    public String getName() {
        return name;
    }

    public Action getAction() {
        return action;
    }

    public State getToState() {
        return toState;
    }

    public State getFromState() {
        return fromState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return name.equals(that.name) &&
                fromState.equals(that.fromState) &&
                action.equals(that.action) &&
                toState.equals(that.toState);
    }
}
