package designpatterns.yesteryearyonder.interfaces.daos;

import java.time.LocalDate;

import designpatterns.yesteryearyonder.models.Booking;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.User;

public interface BookingDao {

    Booking create(User user, TimeMachine timeMachine, String city, LocalDate startDate,
            LocalDate endDate);

    void cancel(long bookingId);

    Booking findById(long bookingId);
}
