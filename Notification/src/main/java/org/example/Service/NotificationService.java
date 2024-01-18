package org.example.Service;

import org.example.Entity.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {



        @Autowired
        private JavaMailSender mailSender;

        public String sendEmail(Notifications notifications) {



            try {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(notifications.getEmail());
                message.setSubject("Your Reservation Information");
                message.setText("Merhaba " +notifications.getUser()+ "\nYour room: "+notifications.getRoom()+ " \nReservation start date:" +notifications.getStartdate()+ "\nReservation end date:" + notifications.getEnddate());

                mailSender.send(message);
                return "Email sent succcessfully";
            }
            catch (Exception e) {
                e.printStackTrace();
                return "Error sending email: " + e.getMessage();
            }

        }


}
