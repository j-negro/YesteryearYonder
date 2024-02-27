package designpatterns.yesteryearyonder.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import designpatterns.yesteryearyonder.interfaces.services.EmailService;
import designpatterns.yesteryearyonder.interfaces.services.UserService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserService userService;

    @Override
    public void notifyAvailableSpaceTimeSlot(String city, String startDate, String endDate) {

        Set<String> userEmails = userService.getUserEmails();

        for (String to : userEmails) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("yesteryearyonder@gmail.com");
            message.setTo(to);
            message.setSubject("Time travel available");
            message.setText("We have a time travel space available in " + city + " from " + startDate + " to " + endDate
                    + ". Please contact us to book your trip!");

            mailSender.send(message);

        }
    }

}
