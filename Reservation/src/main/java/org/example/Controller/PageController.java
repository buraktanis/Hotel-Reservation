package org.example.Controller;
import org.example.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class PageController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservation")
    public String showReservationPage() {

        return "reservation";
    }

}
