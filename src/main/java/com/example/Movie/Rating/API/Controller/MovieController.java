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

//   @PutMapping("/{id}")
//    public ResponseEntity<Movie> updateMovie(@PathVariable(Long id), @RequestBody(Movie movie)) {
//        Movie updatedMovie = movieService.updateMovie(id, movie);
//        if (updatedMovie != null) {
//            return ResponseEntity.ok(updatedMovie);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PutMapping("/update/{id}")
    public String editCourse(@RequestBody Movie movie){
        Movie editMovie = movieService.editMovie(movie);
        return "editing course id ";}


    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);

        return "Movie id " + id + " Deleted";
    }

}