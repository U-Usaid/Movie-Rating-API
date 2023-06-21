package com.example.Movie.Rating.API.Service;

import com.example.Movie.Rating.API.Model.Movie;
import com.example.Movie.Rating.API.Model.Rating;
import com.example.Movie.Rating.API.Repositories.MovieRepository;
import com.example.Movie.Rating.API.Repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    MovieRepository movieRepository;

    public Rating add(Rating rating, Long movieId){
        Movie movie = movieRepository.findById(movieId).get();
        rating.setRatedMovie(movie);
        return ratingRepository.save(rating);
    }


}
