package com.bookshow.services.impl;

import com.bookshow.exceptions.BookingException;
import com.bookshow.model.Booking;
import com.bookshow.model.Show;
import com.bookshow.model.Slot;
import com.bookshow.model.User;
import com.bookshow.repository.BookingRepository;
import com.bookshow.repository.ShowRepository;
import com.bookshow.repository.SlotRepository;
import com.bookshow.services.BookingService;
import com.bookshow.services.WaitlistService;

public class BookingServiceImpl implements BookingService {
    static int idCounter = 0;
    private ShowRepository showRepository;
    private SlotRepository slotRepository;
    private BookingRepository bookingRepository;
    private WaitlistService waitlistService;

    public BookingServiceImpl(ShowRepository showRepository, SlotRepository slotRepository,
                              BookingRepository bookingRepository, WaitlistService waitlistService) {
        this.showRepository = showRepository;
        this.slotRepository = slotRepository;
        this.bookingRepository = bookingRepository;
        this.waitlistService = waitlistService;
    }

    @Override
    public Booking bookTicket(User user, String showName, String timeSlot) {
        Show show = showRepository.findShowByName(showName);
        if (show == null) {
            throw new BookingException("Show not found");
        }

        Slot slot = slotRepository.findSlotByShowAndTime(showName, timeSlot);
        if (slot == null) {
            throw new BookingException("Slot not available for "+ showName);
        }

        if (slot.isFull()) {
            waitlistService.addToWaitlist(user, slot);
            throw new BookingException("Slot is full for "+showRepository+", added to waitlist");
        }

        Booking booking = new Booking(getIdCounter(), user, slot);
        slot.addBooking(booking);
        bookingRepository.saveBooking(booking);
        return booking;
    }
    private String getIdCounter(){
        idCounter++;
        return idCounter+"";
    }
    @Override
    public void cancelBooking(String bookingId) {
        // Find the booking by bookingId
        Booking booking = bookingRepository.findBookingById(bookingId);
        if (booking == null) {
            throw new BookingException("Booking not found for ID: " + bookingId);
        }

        // Get the associated slot
        Slot slot = booking.getSlot();

        // Remove the booking from the slot and reduce the available capacity
        slot.removeBooking(booking);
        bookingRepository.deleteBooking(bookingId);

        // Check if there's anyone in the waitlist for this slot
        User waitlistUser = waitlistService.getNextFromWaitlist(slot);
        if (waitlistUser != null) {
            // If a user is in the waitlist, assign the available seat to them
            Booking newBooking = new Booking(getIdCounter(), waitlistUser, slot);
            slot.addBooking(newBooking); // Increment slot capacity
            bookingRepository.saveBooking(newBooking); // Save the new booking

            System.out.println("Waitlist user " + waitlistUser.getUserName() + " has been moved from waitlist to booking.");
        } else {
            System.out.println("Booking cancelled. No waitlist users for this slot.");
        }
    }

}
