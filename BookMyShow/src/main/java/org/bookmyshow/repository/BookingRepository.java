package org.bookmyshow.repository;

import org.bookmyshow.model.Booking;

import java.util.List;

public interface BookingRepository {
    void addBooking(Booking booking);

    List<Booking> getBookingsForUser(int userId);
}
