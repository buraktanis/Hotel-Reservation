package com.hotelreservation.app.controller;

import com.hotelreservation.app.entity.Users;
import com.hotelreservation.app.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/room")
    public String showRoomsPage() {
        return "rooms";
    }

    @PostMapping("/users")
    public String saveUser(@RequestBody Users user) throws ExecutionException, InterruptedException {
        return userService.saveUser(user);
    }

    @GetMapping("/users/{id}")
    public Users getUser(@PathVariable Integer id) throws ExecutionException, InterruptedException {

        return userService.getUserDetails(id);
    }

}
