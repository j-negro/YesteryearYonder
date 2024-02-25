package designpatterns.yesteryearyonder.interfaces.services;

import java.time.LocalDate;

import designpatterns.yesteryearyonder.models.Booking;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.User;

public interface BookingService {

    Booking create(User user, TimeMachine timeMachine, String city, LocalDate startDate,
            LocalDate endDate);

    void cancel(long bookingId);

}
