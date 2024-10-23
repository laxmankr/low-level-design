package org.bookmyshow.repository;

import org.bookmyshow.model.Show;

import java.util.List;

public interface ShowRepository {
    void addShow(Show show);

    Show getShowById(int showId);

    List<Show> getShowsForMovie(int movieId);
}
