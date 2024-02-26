package designpatterns.yesteryearyonder.interfaces.services;

import java.time.LocalDate;
import java.util.Optional;

import designpatterns.yesteryearyonder.models.Booking;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.User;

public interface BookingService {

    Booking create(User user, TimeMachine timeMachine, String city, LocalDate startDate,
            LocalDate endDate);

    void cancel(long bookingId);

    boolean isValidTimePeriod(LocalDate startDate, LocalDate endDate);

    void confirmBooking(long bookingId);

    Optional<Booking> findById(long bookingId);

    void cancelBooking(long bookingId);

    boolean checkBookingCollision(String city, LocalDate startDate, LocalDate endDate);
}
