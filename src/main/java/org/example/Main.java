package com.cinemate;

import com.cinemate.model.Movie;
import com.cinemate.service.BookingManager;
import com.cinemate.service.MovieRecommendationService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Welcome to Cinemate AI ===");

        // 1. Test AI Recommendation Concierge
        MovieRecommendationService aiConcierge = new MovieRecommendationService();
        List<Movie> recommendations = aiConcierge.getRecommendations("Sci-Fi");

        System.out.println("AI Recommendations found:");
        for (Movie m : recommendations) {
            System.out.println(" - " + m);
        }

        // 2. Test Seat Booking Manager
        System.out.println("\n--- Initializing Booking System ---");
        BookingManager bookingManager = new BookingManager();
        bookingManager.displaySeats();

        System.out.println("\nBooking seat A1...");
        bookingManager.bookSeat("A1");

        System.out.println("\nTrying to book seat A1 again (Double-booking test):");
        bookingManager.bookSeat("A1");
    }
}