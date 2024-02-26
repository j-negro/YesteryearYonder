package designpatterns.yesteryearyonder.interfaces.services;

import java.util.Optional;
import java.util.Set;
import designpatterns.yesteryearyonder.models.TimeMachine;

public interface TimeMachineService {

    TimeMachine create(String name);

    Set<TimeMachine> getTimeMachines(int limit, int offset);

    Optional<TimeMachine> getTimeMachineById(long id);

    TimeMachine createTimeTurner(String name);

    boolean checkMachineUsage(TimeMachine timeMachine);
}
