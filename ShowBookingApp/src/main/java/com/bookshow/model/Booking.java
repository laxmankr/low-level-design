package com.bookshow.model;

public class Booking {
    private String bookingId;
    private User user;
    private Slot slot;

    public Booking(String bookingId, User user, Slot slot) {
        this.bookingId = bookingId;
        this.user = user;
        this.slot = slot;
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Slot getSlot() {
        return slot;
    }

    @Override
    public String toString() {
//        return "Booking{" +
//                "bookingId='" + bookingId + '\'' +
//                ", user=" + user.getUserName() +
//                ", slot=" + slot.toString() +
//                '}';

       return  "Ticket is booked for user: "+user.getUserName() + " and slot: "+slot.getTimeSlot()+" BookingId: "+bookingId;
    }
}
