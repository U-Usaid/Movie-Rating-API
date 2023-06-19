package com.example.Movie.Rating.API.Controller;

import com.example.Movie.Rating.API.Model.User;
import com.example.Movie.Rating.API.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        // Call the UserService to register the user
        userService.registerUser(user);

        // Redirect to the login page or any other desired page
        return "redirect:/login";
    }
}

