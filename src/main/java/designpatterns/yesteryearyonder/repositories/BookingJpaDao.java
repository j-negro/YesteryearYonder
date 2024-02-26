package designpatterns.yesteryearyonder.repositories;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import designpatterns.yesteryearyonder.interfaces.daos.BookingDao;
import designpatterns.yesteryearyonder.models.Booking;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

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
        entityManager.remove(booking); // TODO: Soft delete
    }

    @Override
    public Optional<Booking> findById(long bookingId) {
        try {
            final Booking booking = entityManager.find(Booking.class, bookingId);
            return Optional.of(booking);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    @Override
    public Set<Booking> findByTimeSpace(String city, LocalDate startDate, LocalDate endDate) {
        TypedQuery<Booking> query = entityManager.createQuery(
                "SELECT b FROM Booking b WHERE b.city = :city AND b.startDate <= :endDate AND b.endDate >= :startDate",
                Booking.class);
        query.setParameter("city", city);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return Set.copyOf(query.getResultList());
    }
}
