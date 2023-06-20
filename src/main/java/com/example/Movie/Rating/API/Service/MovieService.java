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


    //Movie Deletion
    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }


    //Movie Rating
    public Movie rateMovie(Long id, Integer rating, String review) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            // Calculate new average rating
            double currentRatingSum = movie.getAverageRating() * movie.getTotalRatings();
            double newRatingSum = currentRatingSum + rating;
            int newTotalRatings = movie.getTotalRatings() + 1;
            double newAverageRating = newRatingSum / newTotalRatings;

            // Update movie properties
            movie.setAverageRating(newAverageRating);
            movie.setTotalRatings(newTotalRatings);

            // Save the updated movie to the database
            return movieRepository.save(movie);
        }
        return null;
    }


}
