package org.bookmyshow.repository;

import org.bookmyshow.model.Theatre;

public interface TheatreRepository {
    void addTheatre(Theatre theatre);
    Theatre getTheatreById(int theatreId);
}
