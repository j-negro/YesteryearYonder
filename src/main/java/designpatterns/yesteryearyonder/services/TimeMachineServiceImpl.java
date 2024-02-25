package designpatterns.yesteryearyonder.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import designpatterns.yesteryearyonder.interfaces.daos.TimeMachineDao;
import designpatterns.yesteryearyonder.interfaces.services.TimeMachineService;
import designpatterns.yesteryearyonder.models.TimeMachine;

public class TimeMachineServiceImpl implements TimeMachineService {

    @Autowired
    private TimeMachineDao timeMachineDao;

    @Override
    public TimeMachine create(String name) {
        return timeMachineDao.create(name);
    }

    @Override
    public Set<TimeMachine> getTimeMachines(int limit, int offset) {
        return timeMachineDao.getTimeMachines(limit, offset);
    }

}
