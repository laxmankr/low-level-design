package org.bookmyshow;

import org.bookmyshow.model.*;
import org.bookmyshow.repository.BookingRepository;
import org.bookmyshow.repository.MovieRepository;
import org.bookmyshow.repository.ShowRepository;
import org.bookmyshow.repository.TheatreRepository;
import org.bookmyshow.repository.impl.InMemoryBookingRepository;
import org.bookmyshow.repository.impl.InMemoryMovieRepository;
import org.bookmyshow.repository.impl.InMemoryShowRepository;
import org.bookmyshow.repository.impl.InMemoryTheatreRepository;
import org.bookmyshow.service.BookingService;
import org.bookmyshow.service.impl.BookingServiceImpl;

import java.util.Arrays;
import java.util.List;

public class BookMyShowApplication {
    public static void main(String[] args) {
        // Initialize repositories
        MovieRepository movieRepository = new InMemoryMovieRepository();
        TheatreRepository theatreRepository = new InMemoryTheatreRepository();
        ShowRepository showRepository = new InMemoryShowRepository();
        BookingRepository bookingRepository = new InMemoryBookingRepository();

        // Add some sample data
        Movie movie1 = new Movie(1, "Inception", Language.ENGLISH, Genre.ACTION);
        Movie movie2 = new Movie(2, "Dilwale Dulhania Le Jayenge", Language.HINDI, Genre.ROMANCE);
        movieRepository.addMovie(movie1);
        movieRepository.addMovie(movie2);

        Theatre theatre = new Theatre(1, "PVR Cinemas", 100);
        theatreRepository.addTheatre(theatre);

        Show show1 = new Show(1, movie1, "10:00 AM", theatre.getId());
        Show show2 = new Show(2, movie2, "12:00 PM", theatre.getId());
        showRepository.addShow(show1);
        showRepository.addShow(show2);

        // Search for movies
        List<Movie> searchResults = movieRepository.searchMovies("Inception");
        System.out.println("Search Results: ");
        for (Movie movie : searchResults) {
            System.out.println(movie.getName());
        }

        // Book a ticket as a registered user
        BookingService bookingService = new BookingServiceImpl(bookingRepository, theatreRepository, showRepository);
        String bookingResponse = bookingService.bookTicket(1, show1.getId(), Arrays.asList(1, 2, 3));
        System.out.println(bookingResponse);

        // Display user's booking history
        List<Booking> userBookings = bookingRepository.getBookingsForUser(1);
        System.out.println("User's Booking History:");
        for (Booking booking : userBookings) {
            System.out.println("Booking ID: " + booking.getId() + ", Show ID: " + booking.getShowId());
        }
    }
}
