package com.example.securedapp.controller.user;

import com.example.securedapp.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public String create(UserForm form) {
        userService.create(form.username(), form.password());
        return "redirect:/login";
    }
}
