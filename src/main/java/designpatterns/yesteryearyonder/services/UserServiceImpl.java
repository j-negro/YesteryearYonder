package designpatterns.yesteryearyonder.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import designpatterns.yesteryearyonder.interfaces.daos.UserDao;
import designpatterns.yesteryearyonder.interfaces.services.UserService;
import designpatterns.yesteryearyonder.models.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public User create(String username, String password, String email) {

        Optional<User> existingUser = userDao.getUserByUsername(username);

        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }

        existingUser = userDao.getUserByEmail(email);

        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        return userDao.create(username, password, email);
    }

    private static final int MAX_BOOKINGS_PER_USER = 3;

    @Override
    public boolean checkUserBookings(User user) {

        // Time travel is damaging to the user's mental health, so we don't allow
        // users to book more than three trips at a time.

        return user.getBookings().size() < MAX_BOOKINGS_PER_USER;

    }

    @Override
    public Set<String> getUserEmails() {

        return userDao.getUserEmails();
    }

}
