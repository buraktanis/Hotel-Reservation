package org.example.Controller;
import org.example.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class PageController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservation")
    public String showReservationPage(@RequestParam(name = "roomNumber", required = false) Integer roomNumber, Model model) {
        if (roomNumber != null) {
            model.addAttribute("roomNumber", roomNumber);
        }
        return "reservation";
    }
}
