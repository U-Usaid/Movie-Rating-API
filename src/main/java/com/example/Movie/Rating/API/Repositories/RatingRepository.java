package com.example.Movie.Rating.API.Repositories;

import com.example.Movie.Rating.API.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {

}
