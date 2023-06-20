package com.example.Movie.Rating.API.Service;

import com.example.Movie.Rating.API.Model.Movie;
import com.example.Movie.Rating.API.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;



    //Movie Retrieval
    public Movie getMovieById(Long id){
        return movieRepository.findById(id).get();
    }



    //Movie Creation
    public Movie addMovies(Movie movie){
        return movieRepository.save(movie);
    }



    //Movie Update
    public Movie updateMovie(Long id, Movie movie) {
        Movie existingMovie = movieRepository.findById(id).orElse(null);
        if (existingMovie != null) {
            existingMovie.setTitle(movie.getTitle());
            existingMovie.setGenre(movie.getGenre());
            existingMovie.setReleaseYear(movie.getReleaseYear());
            return movieRepository.save(existingMovie);
        }
        return null;
    }

//    public Movie editMovie(Movie movie){
//        return movieRepository.save(movie);
//    }


    //Movie Deletion
    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }


    //Movie Rating



}
