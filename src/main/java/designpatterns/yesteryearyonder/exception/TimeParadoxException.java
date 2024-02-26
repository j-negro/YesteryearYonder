package designpatterns.yesteryearyonder.exception;

public class TimeParadoxException extends RuntimeException {

    public TimeParadoxException() {
        super();
    }

    public TimeParadoxException(String message) {
        super(message);
    }

    public TimeParadoxException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimeParadoxException(Throwable cause) {
        super(cause);
    }
}

