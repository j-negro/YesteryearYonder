package designpatterns.yesteryearyonder.models.exception;

public class OverbookedUserException extends RuntimeException {
    public OverbookedUserException() {
        super("This user has too many bookings. For their own safety, they are not allowed to book any more time machines.");
    }

}
