package org.example.Controller;

import org.example.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/")
public class PageController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification")
    public String showReservationPage(@RequestParam(name = "roomNumber", required = false) Integer roomNumber,
                                      @RequestParam(name = "user", required = false) String user,
                                      @RequestParam(name = "email", required = false) String email,
                                      @RequestParam(name = "startdate", required = false) String startdate,
                                      @RequestParam(name = "enddate", required = false) String enddate, Model model) {

        model.addAttribute("roomNumber", roomNumber);
        model.addAttribute("user", user);
        model.addAttribute("email", email);
        model.addAttribute("startdate", startdate);
        model.addAttribute("enddate", enddate);

        return "notification";
    }
}
