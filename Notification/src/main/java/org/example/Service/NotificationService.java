package org.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {


        @Autowired
        private JavaMailSender javaMailSender;

        public String sendEmail(String to, String subject, String body) {

            try {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo("bburaktaniss@gmail.com");
                message.setSubject("deneme");
                message.setText("merhaba");

                javaMailSender.send(message);
                return "Email sent succcessfully";
            }
            catch (Exception e) {
                e.printStackTrace();
                return "Error sending email: " + e.getMessage();
            }

        }


}
