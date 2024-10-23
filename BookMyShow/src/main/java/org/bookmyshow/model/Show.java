package org.bookmyshow.model;

public class Show {
    private int id;
    private Movie movie;
    private String startTime;
    private int theatreId;

    public Show(int id, Movie movie, String startTime, int theatreId) {
        this.id = id;
        this.movie = movie;
        this.startTime = startTime;
        this.theatreId = theatreId;
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getTheatreId() {
        return theatreId;
    }
}

