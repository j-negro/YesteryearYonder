package designpatterns.yesteryearyonder.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import designpatterns.yesteryearyonder.interfaces.daos.BookingDao;
import designpatterns.yesteryearyonder.interfaces.services.BookingService;
import designpatterns.yesteryearyonder.models.Booking;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.User;
import designpatterns.yesteryearyonder.models.exception.BookingNotFoundException;
import designpatterns.yesteryearyonder.models.exception.TimeParadoxException;

import org.springframework.stereotype.Service;

@Service
public class TimeParadoxWarningDecorator implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public Booking create(User user, TimeMachine timeMachine, String city, LocalDate startDate, LocalDate endDate) {

        if (endDate.isAfter(LocalDate.now())) {
            throw new TimeParadoxException("Time paradox detected! Bookings for future dates are not allowed.");
        }

        if (timeMachine.isTimeTurner() && bookingDao.existsByTimeMachine(timeMachine)) {
            throw new TimeParadoxException("Time paradox detected! The time turner cannot have more than one booking.");
        }

        return bookingDao.create(user, timeMachine, city, startDate, endDate);
    }

    @Override
    public void cancel(long bookingId) {
        bookingDao.cancel(bookingId);
    }

    @Override
    public void confirmBooking(long bookingId) {
        Optional<Booking> booking = bookingDao.findById(bookingId);

        if (booking.isEmpty()) {
            throw new BookingNotFoundException();
        }

        booking.get().getState().confirm(booking.get());
    }

    @Override
    public void cancelBooking(long bookingId) {
        Optional<Booking> booking = bookingDao.findById(bookingId);

        if (booking.isEmpty()) {
            throw new BookingNotFoundException();
        }

        booking.get().getState().cancel(booking.get());
    }

    private boolean isValidTimePeriod(LocalDate startDate, LocalDate endDate) {
        LocalDate currentDate = LocalDate.now();
        return !endDate.isAfter(currentDate) && !endDate.isBefore(startDate);
    }
}
