package designpatterns.yesteryearyonder.interfaces.services;

import java.util.Optional;
import java.util.Set;

import designpatterns.yesteryearyonder.models.User;

public interface UserService {

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByEmail(String email);

    User create(String username, String password, String email);

    boolean checkUserBookings(User user);

    Set<String> getUserEmails();

}
