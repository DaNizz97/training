package com.trainingweb.trainingdiary.controller;

import com.trainingweb.trainingdiary.domain.model.User;
import com.trainingweb.trainingdiary.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String registrationPage(Model model) {
        Optional<User> user = userService.getCurrentAuthUser();
        user.ifPresent(user1 -> model.addAttribute("userName", "Logged in as " + user1.getFirstName() + " " + user1.getLastName()));
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping(value = "/")
    public String registerNewUser(Model model, @Valid User user, BindingResult bindingResult) {
        Optional<User> existUser = userService.findUserByEmail(user.getEmail());
        if(existUser.isPresent()) {
            bindingResult
                    .rejectValue("email", "error.user", "There is already a user registered with the email provided");
        }
        if(bindingResult.hasErrors()) {
            return "registration";
        } else {
            userService.saveUser(user);
            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("user", new User());
            return "registration";
        }
    }
}
