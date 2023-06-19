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
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    //Movie Creation
    public Movie addMovies(Movie movie){
        return movieRepository.save(movie);
    }

    //Movie Update
    public Movie editMovies(Movie movie){
        return movieRepository.save(movie);
    }

    //Movie Deletion
    public void deletedMovies(Long id){
        movieRepository.deleteById(id);
    }


    //Movie Rating



}
