package com.cinemate;

import com.cinemate.model.Movie;
import com.cinemate.service.BookingManager;
import com.cinemate.service.MovieRecommendationService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingManager bookingManager = new BookingManager();
        MovieRecommendationService aiConcierge = new MovieRecommendationService();

        boolean running = true;

        System.out.println("========================================");
        System.out.println("      🎬 WELCOME TO CINEMATE AI 🎬      ");
        System.out.println("========================================");

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Ask AI Concierge for Movie Recommendations");
            System.out.println("2. View Seat Availability");
            System.out.println("3. Book a Seat");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("\n[AI Concierge] What kind of movie are you looking for? ");
                    String query = scanner.nextLine();
                    List<Movie> results = aiConcierge.getRecommendations(query);

                    if (results.isEmpty()) {
                        System.out.println("No movies found matching your request.");
                    } else {
                        System.out.println("\nRecommended Movies:");
                        for (Movie m : results) {
                            System.out.println(" - " + m);
                        }
                    }
                    break;

                case 2:
                    System.out.println();
                    bookingManager.displaySeats();
                    break;

                case 3:
                    System.out.print("\nEnter seat ID to book (e.g., A1, A2): ");
                    String seatId = scanner.nextLine();
                    bookingManager.bookSeat(seatId);
                    break;

                case 4:
                    running = false;
                    System.out.println("\nThank you for using Cinemate AI! Goodbye.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}