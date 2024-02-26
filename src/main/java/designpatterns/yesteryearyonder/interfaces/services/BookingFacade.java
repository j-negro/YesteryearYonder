package designpatterns.yesteryearyonder.interfaces.services;

import java.time.LocalDate;

import designpatterns.yesteryearyonder.models.Booking;

public interface BookingFacade {

    Booking create(String username, long timeMachineId, String city, LocalDate startDate,
            LocalDate endDate);

    void cancel(long bookingId);
}
