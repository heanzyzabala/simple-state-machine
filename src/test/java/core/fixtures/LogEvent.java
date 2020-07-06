package core.fixtures;

import core.Event;

public class LogEvent implements Event {

    @Override
    public void execute() {
        System.out.println("Log");
    }
}
