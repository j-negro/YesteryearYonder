package designpatterns.yesteryearyonder.models.states;

import designpatterns.yesteryearyonder.interfaces.services.BookingState;
import designpatterns.yesteryearyonder.models.Booking;

public class ConfirmedBookingState implements BookingState {
    @Override
    public void confirm(Booking booking) {
        // booking.setState(new ConfirmedBookingState());
    }

    @Override
    public void cancel(Booking booking) {
        // booking.setState(new CanceledBookingState());
    }
}
