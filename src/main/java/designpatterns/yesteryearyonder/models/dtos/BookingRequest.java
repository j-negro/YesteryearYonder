package designpatterns.yesteryearyonder.models.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookingRequest implements Serializable {

    private String city;

    @JsonFormat(pattern = "YYYY-MM-DD")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate startDate;

    @JsonFormat(pattern = "YYYY-MM-DD")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate endDate;

    private String username;
    private long timeMachineId;

    public BookingRequest(
            String city,
            LocalDate startDate,
            LocalDate endDate,
            String username, long timeMachineId) {
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.username = username;
        this.timeMachineId = timeMachineId;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getUsername() {
        return username;
    }

    public long getTimeMachineId() {
        return timeMachineId;
    }

}
