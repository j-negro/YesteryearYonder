package designpatterns.yesteryearyonder.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import designpatterns.yesteryearyonder.interfaces.services.BookingEmailDecorator;
import designpatterns.yesteryearyonder.interfaces.services.BookingFacade;
import designpatterns.yesteryearyonder.interfaces.services.TimeMachineService;
import designpatterns.yesteryearyonder.interfaces.services.UserService;
import designpatterns.yesteryearyonder.models.Booking;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.User;
import designpatterns.yesteryearyonder.models.exception.DamagedTimeMachineException;
import designpatterns.yesteryearyonder.models.exception.InvalidDateRangeException;
import designpatterns.yesteryearyonder.models.exception.OverbookedUserException;
import designpatterns.yesteryearyonder.models.exception.TimeParadoxException;

@Service
public class BookingFacadeImpl implements BookingFacade {

    @Autowired
    private BookingEmailDecorator bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private TimeMachineService timeMachineService;

    @Override
    public Booking create(String username, long timeMachineId, String city, LocalDate startDate, LocalDate endDate) {

        Optional<User> optionalUser = userService.getUserByUsername(username);

        if (!optionalUser.isPresent()) {
            throw new IllegalArgumentException("User does not exist");
        }

        Optional<TimeMachine> optionalTimeMachine = timeMachineService.getTimeMachineById(timeMachineId);

        if (!optionalTimeMachine.isPresent()) {
            throw new IllegalArgumentException("Time machine does not exist");
        }

        User user = optionalUser.get();
        TimeMachine timeMachine = optionalTimeMachine.get();

        if (!userService.checkUserBookings(user)) {
            throw new OverbookedUserException();
        }

        if (!timeMachineService.checkMachineUsage(timeMachine)) {
            throw new DamagedTimeMachineException();
        }

        if (!bookingService.isValidTimePeriod(startDate, endDate)) {
            throw new InvalidDateRangeException();
        }

        if (!bookingService.checkBookingCollision(city, startDate, endDate)) {
            throw new TimeParadoxException();
        }

        return bookingService.create(user, timeMachine, city, startDate, endDate);

    }

    @Override
    public void cancel(long bookingId) {
        Optional<Booking> optionalBooking = bookingService.findById(bookingId);

        if (!optionalBooking.isPresent()) {
            throw new IllegalArgumentException("Booking does not exist");
        }

        bookingService.cancel(optionalBooking.get());
    }

}
