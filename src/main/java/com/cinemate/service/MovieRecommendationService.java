package com.cinemate.service;

import com.cinemate.model.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRecommendationService {
    private List<Movie> catalog;

    public MovieRecommendationService() {
        this.catalog = new ArrayList<>();
        // Let's add sample movies to our database catalog
        catalog.add(new Movie("Interstellar", "Sci-Fi", "A team of explorers travel through a wormhole in space.", 8.7));
        catalog.add(new Movie("The Dark Knight", "Action", "When the menace known as the Joker wreaks havoc and chaos.", 9.0));
        catalog.add(new Movie("Inception", "Sci-Fi", "A thief who steals corporate secrets through dream-sharing technology.", 8.8));
        catalog.add(new Movie("The Hangover", "Comedy", "Three buddies wake up from a bachelor party in Las Vegas with no memory.", 7.7));
    }

    // AI Concierge simulation: matches user query against genres, titles, or synopses
    public List<Movie> getRecommendations(String query) {
        System.out.println("\n[Cinemate AI Concierge] Analyzing query: \"" + query + "\"...");
        String lowerQuery = query.toLowerCase();

        return catalog.stream()
                .filter(m -> m.getGenre().toLowerCase().contains(lowerQuery) ||
                        m.getTitle().toLowerCase().contains(lowerQuery) ||
                        m.getSynopsis().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toList());
    }
}