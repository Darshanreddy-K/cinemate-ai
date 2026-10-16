package com.cinemate.service;

import com.cinemate.model.Seat;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Seat> availableSeats;

    public BookingManager() {
        this.availableSeats = new ArrayList<>();
        // Let's initialize a sample screen with 5 seats (A1 to A5)
        for (int i = 1; i <= 5; i++) {
            availableSeats.add(new Seat("A", i));
        }
    }

    // Method to display all seats and their current status
    public void displaySeats() {
        System.out.println("--- Current Seat Availability ---");
        for (Seat seat : availableSeats) {
            String status = seat.isBooked() ? "[BOOKED]" : "[AVAILABLE]";
            System.out.println("Seat " + seat.getSeatId() + " " + status);
        }
    }

    // Method to book a seat with concurrency / double-booking check
    public boolean bookSeat(String seatId) {
        for (Seat seat : availableSeats) {
            if (seat.getSeatId().equalsIgnoreCase(seatId)) {
                // Check if already booked (prevents double-booking race condition)
                if (seat.isBooked()) {
                    System.out.println("Error: Seat " + seatId + " is already booked!");
                    return false;
                }
                seat.bookSeat();
                System.out.println("Success: Seat " + seatId + " booked successfully!");
                return true;
            }
        }
        System.out.println("Error: Seat " + seatId + " not found!");
        return false;
    }
}