package designpatterns.yesteryearyonder.interfaces.daos;

import java.util.Optional;
import java.util.Set;

import designpatterns.yesteryearyonder.models.User;

public interface UserDao {

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByEmail(String email);

    User create(String username, String password, String email);

    Set<String> getUserEmails();
}
