package designpatterns.yesteryearyonder.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import designpatterns.yesteryearyonder.interfaces.daos.TimeMachineDao;
import designpatterns.yesteryearyonder.interfaces.services.TimeMachineService;
import designpatterns.yesteryearyonder.models.TimeMachine;

@Service
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

    @Override
    public TimeMachine createTimeTurner(String name) {
        return new TimeMachine("Time Turner", name);
    }

    private static final int MAX_BOOKINGS_PER_MACHINE = 10;

    @Override
    public boolean checkMachineUsage(TimeMachine timeMachine) {
        // Time travel is damaging to the time machine's temporal integrity, so we don't
        // allow more than three trips at a time.
        return timeMachine.getBookings().size() < MAX_BOOKINGS_PER_MACHINE;
    }

    @Override
    public Optional<TimeMachine> getTimeMachineById(long id) {
        return timeMachineDao.getTimeMachineById(id);
    }

}
