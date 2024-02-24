package designpatterns.yesteryearyonder.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class TimeMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timemachine_id_seq")
    @Column(name = "timemachine_id")
    private long timeMachineId;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    public TimeMachine() {
    }

    public TimeMachine(String name) {
        this.name = name;
    }

    public Long getTimeMachineId() {
        return timeMachineId;
    }

}
