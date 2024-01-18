package org.example.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
@RequestMapping("/api/room")
public class RoomDetailController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public List<Rooms> getAllRooms() throws ExecutionException, InterruptedException {
        return roomService.getAllRooms();
    }
    @Operation(description="return author infor by give author id")
    @ApiResponse(responseCode = "200", description = "Successful")
    @GetMapping("/rooms/{id}")
    public Rooms getRoom(@Parameter(name="id",description = "Author id", required = true)
                             @PathVariable Integer id) throws ExecutionException, InterruptedException {

        return roomService.getRoomDetails(id);
    }
}
