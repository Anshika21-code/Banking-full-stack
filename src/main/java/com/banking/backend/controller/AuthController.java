package com.banking.backend.controller;

import com.banking.backend.model.dto.LoginRequest;
import com.banking.backend.model.dto.RegisterRequest;
import com.banking.backend.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.banking.backend.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        User user = new User();
        user.setFullName(req.fullName);
        user.setEmail(req.email);
        user.setPassword(req.password);

        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        return ResponseEntity.ok(
                userService.login(req.email, req.password)
        );
    }
}
