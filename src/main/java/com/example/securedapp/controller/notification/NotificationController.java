package com.example.securedapp.controller.notification;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotificationController {

    @GetMapping("/notifications/creationForm")
    public String showCreationForm() {
        return "notification/creationForm";
    }

    @PostMapping("/notifications")
    public String create(NotificationForm form) {
        return "redirect:/";
    }
}
