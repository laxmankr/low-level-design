package org.bookmyshow.model;

public class Movie {
    private int id;
    private String name;
    private Language language;
    private Genre genre;

    public Movie(int id, String name, Language language, Genre genre) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Language getLanguage() {
        return language;
    }

    public Genre getGenre() {
        return genre;
    }
}