package org.bookmyshow.model;

import java.util.List;

public class Booking {
    private int id;
    private int userId;
    private int showId;
    private List<Integer> seatNumbers;

    public Booking(int id, int userId, int showId, List<Integer> seatNumbers) {
        this.id = id;
        this.userId = userId;
        this.showId = showId;
        this.seatNumbers = seatNumbers;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getShowId() {
        return showId;
    }

    public List<Integer> getSeatNumbers() {
        return seatNumbers;
    }
}
