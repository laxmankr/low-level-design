package com.bookshow.repository;

import com.bookshow.model.Booking;
import com.bookshow.model.User;

import java.util.List;

public interface BookingRepository {
    void saveBooking(Booking booking);
    Booking findBookingById(String bookingId);
    List<Booking> findAllBookings();
    void deleteBooking(String bookingId);
    List<Booking> findBookingByUser(User user);
}
