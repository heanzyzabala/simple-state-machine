package core;

public class LogEvent implements Event {

    @Override
    public void execute() {
        System.out.println("Log");
    }
}
