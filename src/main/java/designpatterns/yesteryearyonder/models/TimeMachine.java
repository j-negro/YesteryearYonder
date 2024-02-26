package designpatterns.yesteryearyonder.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "timemachines")
public class TimeMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timemachine_id_seq")
    @Column(name = "timemachine_id")
    private long timeMachineId;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @OneToMany(mappedBy = "timeMachine", fetch = FetchType.LAZY)
    private Set<Booking> bookings;

    public TimeMachine() {
    }

    public TimeMachine(String name) {
        this.name = name;
    }

    public TimeMachine(String timeTurner, String name) {
    }

    public String getName() {
        return name;
    }

    public Long getTimeMachineId() {
        return timeMachineId;
    }

    public boolean isTimeTurner() {
        return this.name.toLowerCase().contains("time turner");
    }
}
