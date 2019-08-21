package core;

public class ActionBuilder {
    private Action action;

    public ActionBuilder() {
        action = new Action();
    }

    public ActionBuilder name(String name) {
        action.setName(name);
        return this;
    }

    public ActionBuilder event(Event event) {
        action.setEvent(event);
        return this;
    }

    public Action build() {
        return action;
    }
}
