package designpatterns.yesteryearyonder.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id_seq")
    private long id;

    @Column(name = "city", nullable = false, length = 64)
    private String city;

    @Column(name = "date", nullable = false, length = 64)
    private String date;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("timeMachineId")
    @JoinColumn(name = "timemachine_id")
    private TimeMachine timeMachine;

    public Booking() {
    }

    public Booking(User user, TimeMachine timeMachine) {
        this.user = user;
        this.timeMachine = timeMachine;
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

}
