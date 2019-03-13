package com.trainingweb.trainingdiary.controller;

import com.trainingweb.trainingdiary.domain.model.User;
import com.trainingweb.trainingdiary.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(value = "/login")
public class LoginController {


    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String login(Model model) {
        Optional<User> user = userService.getCurrentAuthUser();
        user.ifPresent((user1) -> model.addAttribute("userName", "Logged in as" + user1.getFirstName() + " " + user1.getLastName()));
/*        if (user.isPresent())
            model.addAttribute("userName", "Logged in as " + user.get().getFirstName() + " " + user.getLastName());*/
        return "login";
    }



    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
