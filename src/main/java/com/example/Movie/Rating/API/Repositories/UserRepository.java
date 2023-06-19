package com.example.Movie.Rating.API.Repositories;

import com.example.Movie.Rating.API.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long > {
    User findByUsername(String username);
}
