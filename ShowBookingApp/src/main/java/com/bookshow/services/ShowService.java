package com.bookshow.services;

import com.bookshow.model.Genre;
import com.bookshow.model.Show;
import com.bookshow.model.Slot;

import java.util.List;

public interface ShowService {
    void registerShow(String showName, Genre genre);

    void onboardShowSlots(String showName, List<Slot> slots);

    List<Show> showAvailByGenre(Genre genre);
}