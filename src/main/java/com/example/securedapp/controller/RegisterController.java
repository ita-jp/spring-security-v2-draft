package com.example.securedapp.controller;

import com.example.securedapp.controller.user.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String show(Model model) {
        if (!model.containsAttribute("userForm")) {
            model.addAttribute(new UserForm(null, null));
        }
        return "register";
    }
}
