package com.bookshow;

import com.bookshow.exceptions.BookingException;
import com.bookshow.exceptions.ShowException;
import com.bookshow.exceptions.SlotException;
import com.bookshow.model.*;
import com.bookshow.repository.impl.InMemoryBookingRepository;
import com.bookshow.repository.impl.InMemoryShowRepository;
import com.bookshow.repository.impl.InMemorySlotRepository;
import com.bookshow.services.impl.BookingServiceImpl;
import com.bookshow.services.impl.ShowServiceImpl;
import com.bookshow.services.impl.WaitlistServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShowBookingApplication{
    public static void main(String[] args) {
        InMemoryShowRepository showRepository = new InMemoryShowRepository();
        InMemorySlotRepository slotRepository = new InMemorySlotRepository();
        InMemoryBookingRepository bookingRepository = new InMemoryBookingRepository();


        ShowServiceImpl showService = new ShowServiceImpl(showRepository, slotRepository);
        WaitlistServiceImpl waitlistService = new WaitlistServiceImpl();
        BookingServiceImpl bookingService = new BookingServiceImpl(showRepository, slotRepository, bookingRepository, waitlistService);

        try {
            InputStream inputStream = ShowBookingApplication.class.getClassLoader().getResourceAsStream("input.txt");
            assert inputStream != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while ((line = reader.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(" ");

                // Handle registerShow command
                if (parts[0].equals("registerShow")) {
                    String showName = parts[1];
                    Genre genre = Genre.valueOf(parts[2].toUpperCase());

                    try {
                        showService.registerShow(showName, genre);
                    } catch (BookingException | ShowException | SlotException e) {
                        System.err.println("Error: " + e.getMessage());
                    } catch (Exception e) {
                        System.err.println("Unknown error.");
                    }
                }

                // Handle onboardShowSlots command
                else if (parts[0].equals("onboardShowSlots")) {
                    String showName = parts[1];
                    List<Slot> slots = new ArrayList<>();

                    // Extract slot times and capacities from the rest of the input
                    String[] slotDetails = line.substring(line.indexOf(parts[2])).split(", ");
                    for (String slotDetail : slotDetails) {
                        String[] slotInfo = slotDetail.split(" ");
                        String time = slotInfo[0];
                        int capacity = Integer.parseInt(slotInfo[1]);
                        slots.add(new Slot(time, capacity));
                    }

                    try {
                        showService.onboardShowSlots(showName, slots);
                    } catch (BookingException | ShowException | SlotException e) {
                        System.err.println("Error: " + e.getMessage());
                    } catch (Exception e) {
                        System.err.println("Unknown error.");
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//            // Register shows
//
//            showService.registerShow("TMOKC", Genre.COMEDY);
//            showService.registerShow("TMOKC", Genre.THEATER);
//
//        }catch(BookingException | ShowException | SlotException e){
//            System.err.println("Error: " + e.getMessage());
//        } catch (Exception e) {
//            System.err.println("Unknown error..");
//        }
////            showService.onboardShowSlots("TMOKC", Arrays.asList(
////                    new Slot("9:00-10:00", 5)
////            ));
//
//        //onboardShowSlots: TMKOC 9:00-10:00 3, 12:00-13:00 2, 15:00-16:00 5
//
//        showService.onboardShowSlots("TMOKC", Arrays.asList(
//                new Slot("9:00-10:00", 1),
//                new Slot("12:00-13:00", 1),
//                new Slot("15:00-16:00", 1)
//
//        ));



//            List<Slot> slots =  slotRepository.findSlotsByShow("TMOKC");
////            System.out.println(slots);
//            for(Slot slot: slots){
//                System.out.println(slot.toString());
//            }
//            //  The Sonu Nigam Live Event -> Singing
//            showService.registerShow("The Sonu Nigam Live Event", Genre.SINGING);
//
//            //onboardShowSlots: The Sonu Nigam Live Event 10:00-11:00 3, 13:00-14:00 2, 17:00-18:00 1
//
//            showService.onboardShowSlots("The Sonu Nigam Live Event", Arrays.asList(
//                    new Slot("10:00-11:00", 1),
//                    new Slot("13:00-14:00", 1),
//                    new Slot("17:00-18:00", 1)
//            ));
//
////            showRepository.findAllShowsByGenre(Genre.COMEDY);
//
//        System.out.println("All available show by genre comedy:");
//             for(Show show: showService.showAvailByGenre(Genre.COMEDY)){
//                System.out.println(show.toString());
//             }
//
//        System.out.println("All available show by genre singing:");
//        for(Show show: showService.showAvailByGenre(Genre.SINGING)){
//            System.out.println(show.toString());
//        }
//
//        System.out.println("All available show by genre Tech:");
//        for(Show show: showService.showAvailByGenre(Genre.TECH)){
//            System.out.println(show.toString());
//        }
//
//
//
////        bookTicket: (UserA, TMKOC, 12:00, 2)
////        showAvailByGenre: Comedy
//        User user = new User("UserA");
//        System.out.println(bookingService.bookTicket(user, "TMOKC", "12:00-13:00").toString());
//
//        System.out.println("All available show by genre comedy:");
//        for(Show show: showService.showAvailByGenre(Genre.COMEDY)){
//            System.out.println(show.toString());
//        }
//        System.out.println("Booking for userA");
//        for(Booking booking: bookingRepository.findBookingByUser(user)){
//            System.out.println(booking.toString());
//        }
//        bookingService.cancelBooking("1");
//        System.out.println("Booking for userA");
//        if( bookingRepository.findBookingByUser(user).isEmpty()){
//            System.out.println("no booking available");
//        }else{
//            for(Booking booking: bookingRepository.findBookingByUser(user)){
//                System.out.println(booking.toString());
//            }
//        }



//            showService.registerShow("TMKOC", Genre.COMEDY);
//            showService.onboardShowSlots("TMKOC", Arrays.asList(
//                    new Slot("9:00-10:00", 3),
//                    new Slot("12:00-13:00", 2),
//                    new Slot("15:00-16:00", 5)
//            ));
//
//            showService.registerShow("TKSS", Genre.COMEDY);
//            showService.onboardShowSlots("TKSS", Arrays.asList(
//                    new Slot("17:00-18:00", 50),
//                    new Slot("12:00-13:00", 60)
//            ));
//            for(Show show: showService.showAvailByGenre(Genre.COMEDY)){
//                System.out.println(show.toString());
//            }
//
//            // Book a ticket
//            User user = new User("UserA");
//            System.out.println(bookingService.bookTicket(user, "TMKOC", "12:00-13:00").toString());
//            System.out.println(bookingService.bookTicket(user, "TKSS", "17:00-18:00").toString());
//
//            System.out.println("\nGet all bookings:");
//            List<Booking> bookings =  bookingRepository.findAllBookings();
//            for(Booking booking: bookings){
//                System.out.println(booking.toString());
//            }
//            bookingService.cancelBooking("1");
//            System.out.println("\nGet all bookings:");
//            bookings =  bookingRepository.findAllBookings();
//            for(Booking booking: bookings){
//                System.out.println(booking.toString());
//            }
//
//            // To test error fun
//            showService.onboardShowSlots("TKSS", Arrays.asList(
//                    new Slot("11:00-12:00", 50)
//            ));
//



    }
}
