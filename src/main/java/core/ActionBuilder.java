package core;

public class ActionBuilder {
    private final Action action;

    public ActionBuilder() {
        action = new Action();
    }

    public ActionBuilder name(String name) {
        action.setName(name);
        return this;
    }

    public Action build() {
        return action;
    }
}
