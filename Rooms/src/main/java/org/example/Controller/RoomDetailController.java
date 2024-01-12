package org.example.Controller;

import org.example.Entity.Rooms;
import org.example.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;
@RestController
@RequestMapping("/api")
public class RoomDetailController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public List<Rooms> getAllRooms() throws ExecutionException, InterruptedException {
        return roomService.getAllRooms();
    }

    @GetMapping("/rooms/{id}")
    public Rooms getRoom(@PathVariable Integer id) throws ExecutionException, InterruptedException {

        return roomService.getRoomDetails(id);
    }
}
