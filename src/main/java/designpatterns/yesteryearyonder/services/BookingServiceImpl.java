package designpatterns.yesteryearyonder.services;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import designpatterns.yesteryearyonder.interfaces.daos.BookingDao;
import designpatterns.yesteryearyonder.interfaces.services.BookingService;
import designpatterns.yesteryearyonder.models.Booking;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.User;
import designpatterns.yesteryearyonder.models.exception.BookingNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public Booking create(User user, TimeMachine timeMachine, String city, LocalDate startDate, LocalDate endDate) {
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

        // booking.get().getState().confirm(booking.get());
    }

    @Override
    public void cancelBooking(long bookingId) {

        Optional<Booking> booking = bookingDao.findById(bookingId);

        if (booking.isEmpty()) {
            throw new BookingNotFoundException();
        }

        // booking.get().getState().cancel(booking.get());
    }

    @Override
    public boolean isValidTimePeriod(LocalDate startDate, LocalDate endDate) {
        LocalDate currentDate = LocalDate.now();
        return !endDate.isAfter(currentDate) && !endDate.isBefore(startDate);
    }

    @Override
    public boolean checkBookingCollision(String city, LocalDate startDate, LocalDate endDate) {

        Set<Booking> collidingBookings = bookingDao.findByTimeSpace(city, startDate, endDate);

        if (collidingBookings.isEmpty()) {
            return true;
        }

        return false;

    }

    @Override
    public Optional<Booking> findById(long bookingId) {
        return bookingDao.findById(bookingId);
    }

}
