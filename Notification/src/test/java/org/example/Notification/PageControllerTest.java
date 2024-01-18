package org.example.Notification;

import org.example.Controller.PageController;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageControllerTest {

    @Test
    public void testShowReservationPage() {
        // Test senaryosu parametreleri
        String roomNumber = "1";
        String user = "Tuna Han Öztürk";
        String email = "tunahan@example.com";
        String startDate = "2024-01-18";
        String endDate = "2024-01-20";

        PageController pageController = new PageController();

        // Temsili sınıf
        Model model = new BindingAwareModelMap();

        String viewName = pageController.showReservationPage(Integer.valueOf(roomNumber), user, email, startDate, endDate, model);

        // Expected değerler
        assertEquals("notification", viewName);

        assertEquals(1, model.getAttribute("roomNumber"));
        assertEquals("Tuna Han Öztürk", model.getAttribute("user"));
        assertEquals("tunahan@example.com", model.getAttribute("email"));
        assertEquals("2024-01-18", model.getAttribute("startdate"));
        assertEquals("2024-01-20", model.getAttribute("enddate"));
    }
}
