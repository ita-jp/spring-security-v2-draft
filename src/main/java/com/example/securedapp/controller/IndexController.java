package com.example.securedapp.controller;

import com.example.securedapp.service.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final NotificationService notificationService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("notificationList", notificationService.findAll());
        return "index";
    }
}
