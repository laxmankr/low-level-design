package com.bookshow.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Show {
    private String showName;
    private Genre genre;
    private List<Slot> slots;

    public Show(String showName, Genre genre) {
        this.showName = showName;
        this.genre = genre;
        this.slots = new ArrayList<>();
    }

    public String getShowName() {
        return showName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void addSlot(Slot slot) {
        this.slots.add(slot);
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public static String concatenateStrings(List<Slot> inputList) {
        // Join all elements of the list into a single string
        return inputList.stream()
                .map(Slot::toString)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return "Show{" +
                "showName='" + showName + '\'' +
                ", genre=" + genre +
                ", slots=" + concatenateStrings(slots) +
                '}';
    }
}
