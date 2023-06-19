package com.example.Movie.Rating.API.Controller;

import com.example.Movie.Rating.API.Model.Movie;
import com.example.Movie.Rating.API.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/{Id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("Id") Long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
