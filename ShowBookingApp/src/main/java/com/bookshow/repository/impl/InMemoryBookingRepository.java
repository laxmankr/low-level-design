package com.bookshow.repository.impl;

import com.bookshow.model.Booking;
import com.bookshow.model.User;
import com.bookshow.repository.BookingRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryBookingRepository implements BookingRepository {
    private Map<String, Booking> bookingStorage = new HashMap<>();

    @Override
    public void saveBooking(Booking booking) {
        bookingStorage.put(booking.getBookingId(), booking);
    }

    @Override
    public Booking findBookingById(String bookingId) {
        return bookingStorage.get(bookingId);
    }

    @Override
    public List<Booking> findAllBookings() {
        return new ArrayList<>(bookingStorage.values());
    }



    @Override
    public void deleteBooking(String bookingId) {
        bookingStorage.remove(bookingId);
    }

    @Override
    public List<Booking> findBookingByUser(User user) {
        // Get all bookings from the repository
        ArrayList<Booking> allBookings = new ArrayList<>(bookingStorage.values());

        // Filter the bookings by the provided user
        List<Booking> userBookings = allBookings.stream()
                .filter(booking -> booking.getUser().equals(user))
                .collect(Collectors.toList());

        return userBookings;
    }

}
