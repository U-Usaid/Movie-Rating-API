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

    //localhost:8080/get/1
    @GetMapping("/get/{Id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("Id") Long id) {
        Movie movie = movieService.getMovieById(id);
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
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long id, @RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(id, movie);
        if (updatedMovie != null) {
            return ResponseEntity.ok(updatedMovie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);

        return "Movie id " + id + " Deleted";
    }


    //rateMovie
    @PostMapping("/{id}/rating")
    public ResponseEntity<Movie> rateMovie(@PathVariable("id") Long id,
                                           @RequestParam("rating") Integer rating,
                                           @RequestParam("review") String review) {
        Movie ratedMovie = movieService.rateMovie(id, rating, review);
        if (ratedMovie != null) {
            return ResponseEntity.ok(ratedMovie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}