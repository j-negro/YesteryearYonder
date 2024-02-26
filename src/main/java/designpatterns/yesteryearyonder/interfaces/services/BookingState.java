package designpatterns.yesteryearyonder.interfaces.services;

import designpatterns.yesteryearyonder.models.Booking;

public interface BookingState {
    void confirm(Booking booking);
    void cancel(Booking booking);
}
