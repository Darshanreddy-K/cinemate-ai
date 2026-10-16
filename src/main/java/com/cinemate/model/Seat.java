package com.cinemate.model;

public class Seat {
    private String rowIdentifier; // e.g., 'A'
    private int seatNumber;       // e.g., 1, 2
    private boolean isBooked;     // false by default

    public Seat(String rowIdentifier, int seatNumber) {
        this.rowIdentifier = rowIdentifier;
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public String getSeatId() {
        return rowIdentifier + seatNumber;
    }

    public boolean isBooked() { return isBooked; }

    public void bookSeat() {
        this.isBooked = true;
    }
}