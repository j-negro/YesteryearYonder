package designpatterns.yesteryearyonder.models;

import java.time.LocalDate;

import designpatterns.yesteryearyonder.services.BookingStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id_seq")
    private long id;

    @Column(name = "city", nullable = false, length = 64)
    private String city;

    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "endDate", nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "timemachine_id")
    private TimeMachine timeMachine;

    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.ACTIVE;

    public Booking() {
    }

    public Booking(User user, TimeMachine timeMachine, String city, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.timeMachine = timeMachine;
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public TimeMachine getTimeMachine() {
        return timeMachine;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void cancel() {
        status = BookingStatus.CANCELLED;
    }
}
