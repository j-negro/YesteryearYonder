package designpatterns.yesteryearyonder.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import designpatterns.yesteryearyonder.interfaces.services.UserService;
import designpatterns.yesteryearyonder.models.User;
import designpatterns.yesteryearyonder.models.dtos.UserRequest;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam String username) {

        if (username == null || username.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return userService.getUserByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {

        if (userRequest == null) {
            return ResponseEntity.badRequest().build();
        }

        try {
            User user = userService.create(userRequest.getUsername(), userRequest.getPassword(),
                    userRequest.getEmail());

            URI uri = URI.create("/user?username=" + user.getUsername());

            if (uri == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.created(uri).body(user);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
