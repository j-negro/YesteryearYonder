package designpatterns.yesteryearyonder.services;

import designpatterns.yesteryearyonder.interfaces.services.TimeMachineFactory;
import designpatterns.yesteryearyonder.models.TimeMachine;
import designpatterns.yesteryearyonder.models.TimeTurner;

public class TimeTurnerFactory implements TimeMachineFactory {
    private static final int MAX_TIME_TRAVEL_DAYS = 3;

    @Override
    public TimeMachine createTimeMachine(String type, String name) {
        // Logic to create a Time Turner time machine
        TimeTurner timeTurner = new TimeTurner(name);
        timeTurner.setMaxTimeTravelDays(MAX_TIME_TRAVEL_DAYS);
        timeTurner.setCapacity(1);
        return timeTurner;
    }

}
