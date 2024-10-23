package org.bookmyshow.repository;

import org.bookmyshow.model.Movie;

import java.util.List;

public interface MovieRepository {
    void addMovie(Movie movie);
    Movie getMovieById(int movieId);
    List<Movie> getAllMovies();
    List<Movie> searchMovies(String query);
}

