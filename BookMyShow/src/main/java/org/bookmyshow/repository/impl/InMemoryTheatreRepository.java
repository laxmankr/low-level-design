package org.bookmyshow.repository.impl;

import org.bookmyshow.model.Theatre;
import org.bookmyshow.repository.TheatreRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTheatreRepository implements TheatreRepository {
    private Map<Integer, Theatre> theatreStorage = new HashMap<>();

    @Override
    public void addTheatre(Theatre theatre) {
        theatreStorage.put(theatre.getId(), theatre);
    }

    @Override
    public Theatre getTheatreById(int theatreId) {
        return theatreStorage.get(theatreId);
    }
}
