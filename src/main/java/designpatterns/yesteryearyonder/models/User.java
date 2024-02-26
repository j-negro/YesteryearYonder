package designpatterns.yesteryearyonder.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @Column(name = "user_id")
    private long userId;

    @Column(name = "username", nullable = false, unique = true, length = 64)
    private String username;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "email", nullable = false, unique = true, length = 64)
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Booking> bookings;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }
}
