package org.bookmyshow.repository.impl;

import org.bookmyshow.model.Show;
import org.bookmyshow.repository.ShowRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryShowRepository implements ShowRepository {
    private Map<Integer, Show> showStorage = new HashMap<>();

    @Override
    public void addShow(Show show) {
        showStorage.put(show.getId(), show);
    }

    @Override
    public Show getShowById(int showId) {
        return showStorage.get(showId);
    }

    @Override
    public List<Show> getShowsForMovie(int movieId) {
        List<Show> result = new ArrayList<>();
        for (Show show : showStorage.values()) {
            if (show.getMovie().getId() == movieId) {
                result.add(show);
            }
        }
        return result;
    }
}
