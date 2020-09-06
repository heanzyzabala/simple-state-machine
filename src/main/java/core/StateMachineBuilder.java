package core;

public class StateMachineBuilder {
    private final StateMachine stateMachine;

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

    public StateMachine build() {
        return stateMachine;
    }
}
