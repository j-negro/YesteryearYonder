package designpatterns.yesteryearyonder.interfaces.daos;

import java.time.LocalDate;

import designpatterns.yesteryearyonder.model.Booking;
import designpatterns.yesteryearyonder.model.TimeMachine;
import designpatterns.yesteryearyonder.model.User;

public interface BookingDao {

    Booking create(User user, TimeMachine timeMachine, String city, LocalDate startDate,
            LocalDate endDate);

    void cancel(long bookingId);

}
