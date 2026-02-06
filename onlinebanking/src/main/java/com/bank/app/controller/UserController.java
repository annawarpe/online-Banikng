package com.bank.app.controller;

import com.bank.app.entity.User;
import com.bank.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userdashboard")
    public String userDashboard(@RequestParam String email, Model model) {

        User user = userRepository.findByEmail(email);

        model.addAttribute("user", user);

        return "userdashboard";
    }
}
