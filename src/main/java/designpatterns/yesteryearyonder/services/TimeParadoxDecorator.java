package designpatterns.yesteryearyonder.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import designpatterns.yesteryearyonder.interfaces.daos.BookingDao;
import designpatterns.yesteryearyonder.interfaces.services.BookingService;
import designpatterns.yesteryearyonder.models.Booking;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.User;
import designpatterns.yesteryearyonder.models.exception.TimeParadoxException;

import org.springframework.stereotype.Service;

@Service
public class TimeParadoxDecorator implements BookingService {

    @Autowired
    private final BookingService bookingService;

    public TimeParadoxDecorator(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public Booking create(User user, TimeMachine timeMachine, String city, LocalDate startDate, LocalDate endDate) {
        if (endDate.isAfter(LocalDate.now())) {
            throw new TimeParadoxException();
        }

        if (timeMachine.isTimeTurner() && bookingService.checkBookingCollision(city, startDate, endDate)) {
            throw new TimeParadoxException();
        }

        return bookingService.create(user, timeMachine, city, startDate, endDate);
    }

    // Other methods like cancel, confirmBooking, cancelBooking, and checkBookingCollision are directly delegated to the wrapped bookingService
    @Override
    public void cancel(long bookingId) {
        bookingService.cancel(bookingId);
    }

    @Override
    public boolean isValidTimePeriod(LocalDate startDate, LocalDate endDate) {
        return false;
    }

    @Override
    public void confirmBooking(long bookingId) {
        bookingService.confirmBooking(bookingId);
    }

    @Override
    public Optional<Booking> findById(long bookingId) {
        return Optional.empty();
    }

    @Override
    public void cancelBooking(long bookingId) {
        bookingService.cancelBooking(bookingId);
    }

    @Override
    public boolean checkBookingCollision(String city, LocalDate startDate, LocalDate endDate) {
        return bookingService.checkBookingCollision(city, startDate, endDate);
    }
}
