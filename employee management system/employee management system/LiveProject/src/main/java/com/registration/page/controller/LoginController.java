package com.registration.page.controller;

import com.registration.page.model.Details;
import com.registration.page.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");
        String role = loginData.get("role");

        boolean isAuthenticated = userService.authenticateUser(email, password);

        if (isAuthenticated) {
            Details details = userService.findDetailsByEmail(email);
            if (details != null && details.getRole().equalsIgnoreCase(role)) {
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("message", "Login successful");
                response.put("details", details);
                return ResponseEntity.ok(response);
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", "Invalid credentials or role");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
