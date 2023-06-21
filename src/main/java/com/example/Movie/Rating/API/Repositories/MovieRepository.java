package com.example.Movie.Rating.API.Repositories;

import com.example.Movie.Rating.API.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository  extends JpaRepository<Movie,Long> {
//    @Query("SELECT TOP 10 m.*\n" +
//            "FROM movie m\n" +
//            "JOIN (\n" +
//            "    SELECT movie_id, AVG(rating) AS average_rating\n" +
//            "    FROM rating\n" +
//            "    GROUP BY movie_id\n" +
//            ") r ON m.movie_id = r.movie_id\n" +
//            "ORDER BY r.average_rating DESC;")
//    List<Movie> findTopRatedMovies();
}