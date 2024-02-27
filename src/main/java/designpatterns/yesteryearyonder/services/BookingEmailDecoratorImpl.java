package designpatterns.yesteryearyonder.services;

import java.time.LocalDate;
import java.util.Optional;

import designpatterns.yesteryearyonder.interfaces.services.BookingService;
import designpatterns.yesteryearyonder.interfaces.services.EmailService;
import designpatterns.yesteryearyonder.interfaces.services.BookingEmailDecorator;
import designpatterns.yesteryearyonder.models.Booking;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingEmailDecoratorImpl implements BookingEmailDecorator {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private EmailService emailService;

    @Override
    public void notifyUsersOfNewSlot(String city, String startDate, String endDate) {
        emailService.notifyAvailableSpaceTimeSlot(city, startDate, endDate);
    }

    // Almost all methods are directly delegated to the wrapped bookingService
    @Override
    public Booking create(User user, TimeMachine timeMachine, String city, LocalDate startDate, LocalDate endDate) {
        return bookingService.create(user, timeMachine, city, startDate, endDate);
    }

    @Override
    public void cancel(Booking booking) {
        bookingService.cancel(booking);
        notifyUsersOfNewSlot(booking.getCity(), booking.getStartDate().toString(), booking.getEndDate().toString());
    }

    @Override
    public boolean isValidTimePeriod(LocalDate startDate, LocalDate endDate) {
        return bookingService.isValidTimePeriod(startDate, endDate);
    }

    @Override
    public Optional<Booking> findById(long bookingId) {
        return bookingService.findById(bookingId);
    }

    @Override
    public boolean checkBookingCollision(String city, LocalDate startDate, LocalDate endDate) {
        return bookingService.checkBookingCollision(city, startDate, endDate);
    }

}
