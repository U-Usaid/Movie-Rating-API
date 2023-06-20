package com.example.Movie.Rating.API.Service;

import com.example.Movie.Rating.API.Model.User;
import com.example.Movie.Rating.API.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
//    private final
    @Autowired
    UserRepository userRepository;

//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

//    public User registerUser(User user) {
//        // Check if the username is already taken
//        if (userRepository.findByUsername(user.getUsername()) != null) {
//            throw new IllegalArgumentException("Username already exists");
//        }
//
//        // Save the user to the database
//        return userRepository.save(user);
//    }

    public User add(User user){
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        return userRepository.save(newUser);
    }


}

