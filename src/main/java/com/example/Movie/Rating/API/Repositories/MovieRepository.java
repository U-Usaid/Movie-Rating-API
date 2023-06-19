package com.example.Movie.Rating.API.Repositories;

import com.example.Movie.Rating.API.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository  extends JpaRepository<Movie,Long> {
}
