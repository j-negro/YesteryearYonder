package designpatterns.yesteryearyonder.models.exception;

public class InvalidDateRangeException extends IllegalArgumentException {

    public InvalidDateRangeException() {
        super("Invalid date range! The start date must be before the end date.");
    }

}
