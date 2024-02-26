package designpatterns.yesteryearyonder.services;

import java.time.LocalDate;

import designpatterns.yesteryearyonder.exception.TimeParadoxException;
import org.springframework.beans.factory.annotation.Autowired;

import designpatterns.yesteryearyonder.interfaces.daos.BookingDao;
import designpatterns.yesteryearyonder.interfaces.services.BookingService;
import designpatterns.yesteryearyonder.models.Booking;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.User;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public Booking create(User user, TimeMachine timeMachine, String city, LocalDate startDate, LocalDate endDate) {
        if (!isValidTimePeriod(startDate, endDate)) {
            throw new TimeParadoxException("Time paradox detected! The selected time period is invalid.");
        }
        return bookingDao.create(user, timeMachine, city, startDate, endDate);
    }

    @Override
    public void cancel(long bookingId) {
        bookingDao.cancel(bookingId);
    }

    @Override
    public void confirmBooking(long bookingId) {
        Booking booking = bookingDao.findById(bookingId);
        booking.getState().confirm(booking);
    }

    @Override
    public void cancelBooking(long bookingId) {
        Booking booking = bookingDao.findById(bookingId);
        booking.getState().cancel(booking);
    }

    private boolean isValidTimePeriod(LocalDate startDate, LocalDate endDate) {
        LocalDate currentDate = LocalDate.now();
        return !endDate.isAfter(currentDate) && !endDate.isBefore(startDate);
    }


}
