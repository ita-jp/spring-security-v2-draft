package com.example.securedapp.controller.notification;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotificationController {

    @GetMapping("/notifications/creationForm")
    public String showCreationForm() {
        return "notification/creationForm";
    }
}
