package com.sample.event.controller;

import com.sample.event.dto.LoginRequest;
import com.sample.event.dto.SignupRequest;
import com.sample.event.model.User;
import com.sample.event.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        User user = userService.signup(request.getName(), request.getEmail(), request.getPassword(), request.getRole());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("USER_ALREADY_EXISTS");
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User user = userService.login(request.getEmail(), request.getPassword());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("USER_NOT_FOUND");
        }

        return ResponseEntity.ok(user);
    }
}
