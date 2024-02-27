package designpatterns.yesteryearyonder.services;

import java.time.LocalDate;
import java.util.Optional;

import designpatterns.yesteryearyonder.interfaces.services.BookingService;
import designpatterns.yesteryearyonder.interfaces.services.TimeParadoxDecorator;
import designpatterns.yesteryearyonder.models.Booking;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.User;
import designpatterns.yesteryearyonder.models.exception.TimeParadoxException;

import org.springframework.stereotype.Service;

@Service
public class TimeParadoxDecoratorImpl implements TimeParadoxDecorator {

    private final BookingService bookingService;

    public TimeParadoxDecoratorImpl(BookingService bookingService) {
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

    // Other methods like cancel, confirmBooking, cancelBooking, and
    // checkBookingCollision are directly delegated to the wrapped bookingService
    @Override
    public void cancel(Booking booking) {
        bookingService.cancel(booking);
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

    @Override
    public void test() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'test'");
    }
}
