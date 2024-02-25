package designpatterns.yesteryearyonder.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import designpatterns.yesteryearyonder.interfaces.daos.UserDao;
import designpatterns.yesteryearyonder.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class UserJpaDao implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> getUserByUsername(String username) {
        final TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username",
                User.class);
        query.setParameter("username", username);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public User create(String username, String password, String email) {
        final User user = new User(username, password, email);
        entityManager.persist(user);
        return user;
    }
}
