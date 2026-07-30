package com.cognizant.controller;

import com.cognizant.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @PostMapping("/authenticate")
    public String authenticate(@RequestParam String username,
                               @RequestParam String password) {
        // simple check - in real app use proper auth
        if(username.equals("admin") && password.equals("admin123")) {
            return JwtUtil.generateToken(username);
        }
        return "Invalid credentials";
    }
}
