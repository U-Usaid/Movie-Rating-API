package com.example.Movie.Rating.API.Controller;

import com.example.Movie.Rating.API.Model.Movie;
import com.example.Movie.Rating.API.Model.Rating;
import com.example.Movie.Rating.API.Service.MovieService;
import com.example.Movie.Rating.API.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    MovieService movieService;
    @Autowired
    RatingService ratingService;

    //localhost:8080/get/1
    @GetMapping("/get/{Id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("Id") Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //addMovie
    @PostMapping("/addMovie")
    public Movie createCourse(@RequestBody Movie movie) {
        return movieService.addMovies(movie);
    }


    //UpdateMovie
    @PutMapping("/update/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long movieId, @RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(movieId, movie);
        if (updatedMovie != null) {
            return ResponseEntity.ok(updatedMovie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long movieId) {
        movieService.deleteMovie(movieId);

        return "Movie id " + movieId + " Deleted";
    }

    @PostMapping("/{movieId}/rating")
    public Rating addRating(@RequestBody Rating rating, @PathVariable("movieId") Long movieId){
        return ratingService.add(rating, movieId);
    }

//    @GetMapping("top-rated")
//    public List<Movie> getTopRatedMovies(){
//        return movieService.findTopMovies();
//    }

}