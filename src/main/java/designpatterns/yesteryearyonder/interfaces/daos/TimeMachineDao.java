package designpatterns.yesteryearyonder.interfaces.daos;

import java.util.Optional;
import java.util.Set;

import designpatterns.yesteryearyonder.models.TimeMachine;

public interface TimeMachineDao {

    TimeMachine create(String name);

    Optional<TimeMachine> getTimeMachineById(long id);

    Set<TimeMachine> getTimeMachines(int limit, int offset);
}
