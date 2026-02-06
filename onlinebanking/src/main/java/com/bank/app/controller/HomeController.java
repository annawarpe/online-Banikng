package com.bank.app.controller;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.ArrayList;



import com.bank.app.entity.Customer;
import com.bank.app.entity.Account;
import com.bank.app.entity.Transfer;

import com.bank.app.repository.CustomerRepository;
import com.bank.app.repository.AccountRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bank.app.entity.Message;
import com.bank.app.entity.Register;
import com.bank.app.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.bank.app.entity.Transfer;
import com.bank.app.repository.TransferRepository;
import com.bank.app.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;


@Controller
public class HomeController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private RegisterRepository registerRepo;

    // Home page
    @GetMapping("/")
    public String home() {
        return "home"; // maps to templates/home.html
    }

    // About page
    @GetMapping("/about")
    public String about() {
        return "about"; // templates/about.html
    }

    // User login page
    @GetMapping("/login/user")
    public String userLogin() {
        return "user-login"; // templates/user-login.html
    }

    // Admin login page
    @GetMapping("/login/admin")
    public String adminLogin() {
        return "admin-login"; // templates/admin-login.html
    }

    // Register page
    @GetMapping("/register")
    public String register() {
        return "register"; // templates/register.html
    }

    // Send message API
    @PostMapping("/sendMessage")
    @ResponseBody
    public String sendMessage(@RequestParam("message") String message) {
        Message msg = new Message("User", message);
        messageRepository.save(msg);
        return "Message sent successfully!";
    }

    // User login POST
    @PostMapping("/user/login")
    public String userLoginPost(@RequestParam String email,
                                @RequestParam String password,
                                HttpSession session) {

        Register user = registerRepo.findByEmailAndPassword(email, password);

        if (user != null) {
            session.setAttribute("email", email); // store session

            if (email.equals("admin@gmail.com")) {
                return "redirect:/admin/dashboard";
            }

            return "redirect:/customer/dashboard"; // redirect to dashboard controller
        }

        return "redirect:/login/user"; // back to login page
    }
}