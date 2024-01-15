package org.example.Service;

import org.example.Entity.Rooms;
import org.example.Service.RoomService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoomsServiceTest {

    @Test
    void getAllRoomsTest() throws Exception {
        // Mocking oluşturma
        RoomService roomService = mock(RoomService.class);

        // Mocking expected değerleri belirleme
        Rooms room1 = new Rooms();
        room1.setId(1);
        room1.setHow_many_person(2);
        room1.setPrice(100);
        room1.setDescription("Sample room description");

        Rooms room2 = new Rooms();
        room2.setId(2);
        room2.setHow_many_person(4);
        room2.setPrice(150);
        room2.setDescription("Another room description");

        when(roomService.getAllRooms()).thenReturn(List.of(room1, room2));

        // Test ve sonuçlar
        List<Rooms> result = roomService.getAllRooms();
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(2, result.get(0).getHow_many_person());
        assertEquals(100, result.get(0).getPrice());
        assertEquals("Sample room description", result.get(0).getDescription());
        assertEquals(2, result.get(1).getId());
        assertEquals(4, result.get(1).getHow_many_person());
        assertEquals(150, result.get(1).getPrice());
        assertEquals("Another room description", result.get(1).getDescription());
    }
}
