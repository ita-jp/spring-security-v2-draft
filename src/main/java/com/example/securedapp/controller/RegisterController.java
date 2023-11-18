package com.example.securedapp.controller;

import com.example.securedapp.controller.user.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    public static final String FORM_ATTR_NAME = "userForm";

    @GetMapping("/register")
    public String show(Model model) {
        if (!model.containsAttribute(FORM_ATTR_NAME)) {
            model.addAttribute(FORM_ATTR_NAME, new UserForm(null, null));
        }
        return "register";
    }
}
