package designpatterns.yesteryearyonder.models.exception;

public class TimeParadoxException extends RuntimeException {

    public TimeParadoxException() {
        super("Time paradox detected! The selected time period is invalid.");
    }
}
