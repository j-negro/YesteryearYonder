package designpatterns.yesteryearyonder.repository;

import java.util.Set;

import org.springframework.stereotype.Repository;

import designpatterns.yesteryearyonder.interfaces.daos.TimeMachineDao;
import designpatterns.yesteryearyonder.model.TimeMachine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TimeMachineJpaDao implements TimeMachineDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public TimeMachine create(String name) {
        final TimeMachine timeMachine = new TimeMachine(name);
        entityManager.persist(timeMachine);
        return timeMachine;
    }

    @Override
    public Set<TimeMachine> getTimeMachines(int limit, int offset) {
        return Set.copyOf(
                entityManager.createQuery("SELECT t FROM TimeMachine t", TimeMachine.class).setFirstResult(offset)
                        .setMaxResults(limit).getResultList());
    }

}
