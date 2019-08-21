package core;

public class TransitionBuilder {
    private Transition transition;

    public TransitionBuilder() {
        transition = new Transition();
    }

    public TransitionBuilder name(String name) {
        transition.setName(name);
        return this;
    }

    public TransitionBuilder from(State from) {
        transition.setFromState(from);
        return this;
    }

    public TransitionBuilder action(Action action) {
        transition.setAction(action);
        return this;
    }

    public TransitionBuilder to(State to) {
        transition.setToState(to);
        return this;
    }

    public Transition build() {
        return transition;
    }
}
