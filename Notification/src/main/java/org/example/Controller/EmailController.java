package org.example.Controller;

import org.example.Entity.Notifications;
import org.example.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/notification")
public class EmailController {

    @Autowired
    private NotificationService notificationService;
    @PostMapping("/sendemail")
    public String saveUser(@RequestBody Notifications notifications) throws ExecutionException, InterruptedException {
        return notificationService.sendEmail(notifications);
    }
}

