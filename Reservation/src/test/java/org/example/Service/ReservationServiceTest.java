package org.example.Service;

import org.example.Entity.Reservations;
import org.example.Service.ReservationService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReservationServiceTest {

    @Test
    void saveUserTest() throws Exception {
        // Mocking oluşturma
        ReservationService reservationService = mock(ReservationService.class);


        Reservations reservation = new Reservations();
        reservation.setUser("TestUser");
        when(reservationService.saveUser(reservation)).thenReturn("2022-01-01T12:00:00Z");

        String result = reservationService.saveUser(reservation);
        assertEquals("2022-01-01T12:00:00Z", result);
    }


}
