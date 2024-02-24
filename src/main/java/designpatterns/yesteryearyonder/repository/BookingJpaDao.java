package designpatterns.yesteryearyonder.repository;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

import designpatterns.yesteryearyonder.interfaces.daos.BookingDao;
import designpatterns.yesteryearyonder.model.Booking;
import designpatterns.yesteryearyonder.model.TimeMachine;
import designpatterns.yesteryearyonder.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class BookingJpaDao implements BookingDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Booking create(User user, TimeMachine timeMachine, String city, LocalDate startDate,
            LocalDate endDate) {
        final Booking booking = new Booking(user, timeMachine, city, startDate, endDate);
        entityManager.persist(booking);
        return booking;
    }

    @Override
    public void cancel(long bookingId) {
        final Booking booking = entityManager.find(Booking.class, bookingId);
        entityManager.remove(booking);
    }
}
