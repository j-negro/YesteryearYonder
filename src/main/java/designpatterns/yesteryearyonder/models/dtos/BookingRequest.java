package designpatterns.yesteryearyonder.models.dtos;

import java.time.LocalDate;

public class BookingRequest {

    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
    private long userId;
    private long timeMachineId;

    public BookingRequest(
            String city,
            LocalDate startDate,
            LocalDate endDate,
            long userId,
            long timeMachineId) {
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = userId;
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

    public long getUserId() {
        return userId;
    }

    public long getTimeMachineId() {
        return timeMachineId;
    }

}
