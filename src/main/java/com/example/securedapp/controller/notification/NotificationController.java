package com.example.securedapp.controller.notification;

import com.example.securedapp.service.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/notifications/creationForm")
    public String showCreationForm(@ModelAttribute NotificationForm form) {
        return "notification/creationForm";
    }

    @PostMapping("/notifications")
    public String create(
            @Validated NotificationForm form,
            BindingResult bindingResult,
            Authentication authentication
    ) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form);
        }
        notificationService.create(form.message(), authentication.getName());
        return "redirect:/";
    }
}
