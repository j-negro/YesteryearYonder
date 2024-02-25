package designpatterns.yesteryearyonder.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import designpatterns.yesteryearyonder.interfaces.daos.BookingDao;
import designpatterns.yesteryearyonder.interfaces.services.BookingService;
import designpatterns.yesteryearyonder.models.Booking;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.User;

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

}
