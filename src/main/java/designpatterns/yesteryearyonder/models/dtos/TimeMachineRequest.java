package designpatterns.yesteryearyonder.models.dtos;

import java.io.Serializable;

public class TimeMachineRequest implements Serializable {
    private String name;

    public TimeMachineRequest() {
    }

    public TimeMachineRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
