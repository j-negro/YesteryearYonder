package designpatterns.yesteryearyonder.models.dtos;

import java.io.Serializable;

public class UserRequest implements Serializable {
    private String username;
    private String email;
    private String password;

    public UserRequest() {
    }

    public UserRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
