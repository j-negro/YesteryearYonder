package designpatterns.yesteryearyonder.models.exception;

public class DamagedTimeMachineException extends RuntimeException {
    public DamagedTimeMachineException() {
        super("This time machine has gone on too many adventures and is too damaged to be used.");
    }
}
