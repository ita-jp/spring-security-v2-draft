package com.example.securedapp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @PostMapping("/users")
    public String create(String username, String password) {
        return "redirect:/login";
    }
}
