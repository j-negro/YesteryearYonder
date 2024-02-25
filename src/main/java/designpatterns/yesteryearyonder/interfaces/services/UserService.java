package designpatterns.yesteryearyonder.interfaces.services;

import java.util.Optional;

import designpatterns.yesteryearyonder.models.User;

public interface UserService {

    Optional<User> getUserByUsername(String username);

    User create(String username, String password, String email);
}
