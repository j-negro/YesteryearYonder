package designpatterns.yesteryearyonder.interfaces.daos;

import java.util.Optional;

import designpatterns.yesteryearyonder.model.User;

public interface UserDao {

    Optional<User> getUserByUsername(String username);

    User create(String username, String password, String email);
}
