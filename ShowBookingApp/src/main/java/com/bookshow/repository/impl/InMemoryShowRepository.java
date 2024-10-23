package com.bookshow.repository.impl;

import com.bookshow.model.Genre;
import com.bookshow.model.Show;
import com.bookshow.repository.ShowRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryShowRepository implements ShowRepository {
    private Map<String, Show> showStorage = new HashMap<>();

    @Override
    public void saveShow(Show show) {
        showStorage.put(show.getShowName(), show);
    }

    @Override
    public Show findShowByName(String showName) {
        return showStorage.get(showName);
    }

    @Override
    public List<Show> findAllShowsByGenre(Genre genre) {
        List<Show> showsByGenre = new ArrayList<>();
        for (Show show : showStorage.values()) {
            if (show.getGenre() == genre) {
                showsByGenre.add(show);
            }
        }
        return showsByGenre;
    }
}
