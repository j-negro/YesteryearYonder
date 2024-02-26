package designpatterns.yesteryearyonder.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import designpatterns.yesteryearyonder.interfaces.daos.TimeMachineDao;
import designpatterns.yesteryearyonder.models.TimeMachine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;

@Repository
public class TimeMachineJpaDao implements TimeMachineDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
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

    @Override
    public Optional<TimeMachine> getTimeMachineById(long id) {
        try {
            final TimeMachine timeMachine = entityManager.find(TimeMachine.class, id);
            return Optional.of(timeMachine);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

}
