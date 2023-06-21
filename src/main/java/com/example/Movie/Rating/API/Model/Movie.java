package com.example.Movie.Rating.API.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long movieId;
    String title;
    String genre;
    Date releaseYear;
    @OneToMany(mappedBy = "ratedMovie",cascade = CascadeType.ALL)
    Set<Rating> ratings;

}
