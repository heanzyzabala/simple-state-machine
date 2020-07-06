package core;

public class StateMachineBuilder {
    private StateMachine stateMachine;

    public StateMachineBuilder() {
        stateMachine = new StateMachine();
    }

    public StateMachineBuilder initialState(State state)  {
        stateMachine.setInitialState(state);
        return this;
    }

    public StateMachineBuilder addTransition(Transition transition) {
        stateMachine.addTransition(transition);
        return this;
    }

    public StateMachineBuilder addPostActionEvent(Event e) {
        stateMachine.addPostActionEvent(e);
        return this;
    }

    public StateMachineBuilder addPreActionEvent(Event e) {
        stateMachine.addPreActionEvent(e);
        return this;
    }

    public StateMachine build() {
        return stateMachine;
    }
}
