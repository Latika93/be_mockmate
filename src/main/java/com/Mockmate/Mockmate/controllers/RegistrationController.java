package com.Mockmate.Mockmate.controllers;

import com.Mockmate.Mockmate.entity.User;
import com.Mockmate.Mockmate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private final UserService _userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this._userService = userService;
    }

    @PostMapping("/api/register") // A common practice is to prefix API endpoints with /api
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            _userService.registerUser(user);
            return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle cases where the user already exists or other errors
            return new ResponseEntity<>("Registration failed: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
