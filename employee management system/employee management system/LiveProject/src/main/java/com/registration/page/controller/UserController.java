package com.registration.page.controller;

import com.registration.page.model.User;
import com.registration.page.model.Details;
import com.registration.page.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password) {
        boolean isAuthenticated = userService.authenticateUser(email, password);
        if (isAuthenticated) {
            return "redirect:/home.html";
        } else {
            return "Invalid credentials";
        }
    }

    @GetMapping("/details")
    public Details getUserDetails(@RequestParam String email) {
        return userService.findDetailsByEmail(email);
    }
}
