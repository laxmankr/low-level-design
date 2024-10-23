package org.bookmyshow.repository.impl;

import org.bookmyshow.model.Movie;
import org.bookmyshow.repository.MovieRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryMovieRepository implements MovieRepository {
    private Map<Integer, Movie> movieStorage = new HashMap<>();

    @Override
    public void addMovie(Movie movie) {
        movieStorage.put(movie.getId(), movie);
    }

    @Override
    public Movie getMovieById(int movieId) {
        return movieStorage.get(movieId);
    }

    @Override
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movieStorage.values());
    }

    @Override
    public List<Movie> searchMovies(String query) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movieStorage.values()) {
            if (movie.getName().toLowerCase().contains(query.toLowerCase())) {
                result.add(movie);
            }
        }
        return result;
    }
}
