package com.example.securedapp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @PostMapping("/users")
    public String create(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        return "redirect:/login";
    }
}
