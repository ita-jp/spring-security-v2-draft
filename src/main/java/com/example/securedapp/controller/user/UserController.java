package com.example.securedapp.controller.user;

import com.example.securedapp.controller.RegisterController;
import com.example.securedapp.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public String create(
            @Validated UserForm form,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(RegisterController.FORM_ATTR_NAME, form);
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + Conventions.getVariableName(form), bindingResult);
            return "redirect:/register";
        }
        userService.create(form.username(), form.password());
        return "redirect:/login";
    }

    @GetMapping("/users")
    public String showList(Model model) {
        var userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "user/list";
    }
}
