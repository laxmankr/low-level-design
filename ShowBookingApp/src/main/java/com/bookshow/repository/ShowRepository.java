package com.bookshow.repository;

import com.bookshow.model.Genre;
import com.bookshow.model.Show;
import java.util.List;

public interface ShowRepository {
    void saveShow(Show show);
    Show findShowByName(String showName);
    List<Show> findAllShowsByGenre(Genre genre);
}
