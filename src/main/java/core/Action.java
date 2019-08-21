package core;

public class Action {
    private String name;
    private Event event;

    public Action() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void execute() {
        if(event != null)
            event.execute();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return name.equals(action.name);
    }
}
