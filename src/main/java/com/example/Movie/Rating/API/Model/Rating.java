package com.example.Movie.Rating.API.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ratingId;

    Integer rating;
    String review;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "movieId")
    Movie ratedMovie;
}
