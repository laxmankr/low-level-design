package org.bookmyshow.service;

import java.util.List;

public interface BookingService {
    String bookTicket(int userId, int showId, List<Integer> seatNumbers);
}

