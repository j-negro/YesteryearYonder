package designpatterns.yesteryearyonder.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import designpatterns.yesteryearyonder.interfaces.services.BookingFacade;
import designpatterns.yesteryearyonder.models.Booking;
import designpatterns.yesteryearyonder.models.dtos.BookingRequest;

@RestController
public class BookingController {

    @Autowired
    private BookingFacade bookingFacade;

    @PostMapping("/booking")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest request) {

        if (request == null) {
            return ResponseEntity.badRequest().build();
        }

        try {
            Booking booking = bookingFacade.create(request.getUsername(), request.getTimeMachineId(),
                    request.getCity(), request.getStartDate(), request.getEndDate());

            URI uri = URI.create("/booking?id=" + booking.getId());

            if (uri == null) {
                return ResponseEntity.badRequest().build();
            }

            return ResponseEntity.created(uri).body(booking);

        } catch (Exception e) {
            // Add exception message
            return ResponseEntity.badRequest().build();

        }
    }

    @DeleteMapping("/booking/{id}")
    public ResponseEntity<?> cancelBooking(
            @PathVariable long id) {

        if (id == 0) {
            return ResponseEntity.badRequest().build();
        }

        try {
            bookingFacade.cancel(id);

            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
