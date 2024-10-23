package com.bookshow.services;

import com.bookshow.model.Booking;
import com.bookshow.model.User;

public interface BookingService {
    Booking bookTicket(User user, String showName, String timeSlot);

    void cancelBooking(String bookingId);
}