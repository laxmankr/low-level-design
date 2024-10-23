package com.bookshow.model;

import java.util.ArrayList;
import java.util.List;

public class Slot {
    private String timeSlot;
    private int capacity;
    private List<Booking> bookings;
    private List<User> waitlist;

    public Slot(String timeSlot, int capacity) {
        this.timeSlot = timeSlot;
        this.capacity = capacity;
        this.bookings = new ArrayList<>();
        this.waitlist = new ArrayList<>();
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public boolean isFull() {
        return bookings.size() >= capacity;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    public void removeBooking(Booking booking){
        this.bookings.remove(booking);
    }

    public List<User> getWaitlist() {
        return waitlist;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "timeSlot='" + timeSlot + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
