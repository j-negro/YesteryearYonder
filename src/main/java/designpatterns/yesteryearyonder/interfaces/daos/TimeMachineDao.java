package designpatterns.yesteryearyonder.interfaces.daos;

import java.util.Set;

import designpatterns.yesteryearyonder.models.TimeMachine;

public interface TimeMachineDao {

    TimeMachine create(String name);

    Set<TimeMachine> getTimeMachines(int limit, int offset);
}