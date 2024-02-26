package designpatterns.yesteryearyonder.interfaces.daos;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import designpatterns.yesteryearyonder.models.Booking;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.User;

public interface BookingDao {

    Booking create(User user, TimeMachine timeMachine, String city, LocalDate startDate,
            LocalDate endDate);

    void cancel(long bookingId);

    Optional<Booking> findById(long bookingId);

    Set<Booking> findByTimeSpace(String city, LocalDate startDate, LocalDate endDate);

    boolean existsByTimeMachine(TimeMachine timeMachine);
}
