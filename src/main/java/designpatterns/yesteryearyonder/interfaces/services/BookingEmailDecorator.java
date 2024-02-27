package designpatterns.yesteryearyonder.interfaces.services;

public interface BookingEmailDecorator extends BookingService {

    void notifyUsersOfNewSlot(String city, String startDate, String endDate);

}
