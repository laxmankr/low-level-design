package org.bookmyshow.repository.impl;

import org.bookmyshow.model.Booking;
import org.bookmyshow.repository.BookingRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookingRepository implements BookingRepository {
    private Map<Integer, Booking> bookingStorage = new HashMap<>();

    @Override
    public void addBooking(Booking booking) {
        bookingStorage.put(booking.getId(), booking);
    }

    @Override
    public List<Booking> getBookingsForUser(int userId) {
        List<Booking> result = new ArrayList<>();
        for (Booking booking : bookingStorage.values()) {
            if (booking.getUserId() == userId) {
                result.add(booking);
            }
        }
        return result;
    }
}
