package com.crud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.demo.model.User;
import com.crud.demo.repository.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // login.html
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, 
                              @RequestParam String password,
                              Model model) {
        // Save user to the database
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);

        // Redirect to the webpage after successful login
        return "redirect:/webpage";
    }
}
