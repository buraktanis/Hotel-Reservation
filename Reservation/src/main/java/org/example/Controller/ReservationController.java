package org.example.Controller;

import org.example.Entity.Reservations;
import org.example.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @PostMapping("/save")
    public String saveUser(@RequestBody Reservations reservation) throws ExecutionException, InterruptedException {
        return reservationService.saveUser(reservation);
    }
}
