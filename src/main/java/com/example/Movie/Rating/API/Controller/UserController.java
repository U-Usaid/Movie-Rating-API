package com.example.Movie.Rating.API.Controller;

import com.example.Movie.Rating.API.Model.User;
import com.example.Movie.Rating.API.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> add(@RequestBody User user){
        userService.add(user);
        return ResponseEntity.ok("User registered successfully");
    }
}

