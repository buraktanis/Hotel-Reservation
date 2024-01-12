package org.example.Controller;

import org.example.Entity.Rooms;
import org.example.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public String showRoomsPage() {

        return "rooms";
    }

    @GetMapping("/users/{id}")
    public Rooms getRoom(@PathVariable Integer id) throws ExecutionException, InterruptedException {

        return roomService.getRoomDetails(id);
    }



}