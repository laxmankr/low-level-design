package org.bookmyshow.service.impl;

import org.bookmyshow.model.Booking;
import org.bookmyshow.model.Show;
import org.bookmyshow.model.Theatre;
import org.bookmyshow.repository.BookingRepository;
import org.bookmyshow.repository.ShowRepository;
import org.bookmyshow.repository.TheatreRepository;
import org.bookmyshow.service.BookingService;

import java.util.List;
import java.util.Random;

public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final TheatreRepository theatreRepository;
    private final ShowRepository showRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, TheatreRepository theatreRepository, ShowRepository showRepository) {
        this.bookingRepository = bookingRepository;
        this.theatreRepository = theatreRepository;
        this.showRepository = showRepository;
    }

    @Override
    public String bookTicket(int userId, int showId, List<Integer> seatNumbers) {
        Show show = showRepository.getShowById(showId);
        Theatre theatre = theatreRepository.getTheatreById(show.getTheatreId());

        if (seatNumbers.size() > theatre.getCapacity()) {
            return "Not enough seats available!";
        }

        Booking booking = new Booking(new Random().nextInt(10000), userId, showId, seatNumbers);
        bookingRepository.addBooking(booking);
        return "Booking successful!";
    }
}
