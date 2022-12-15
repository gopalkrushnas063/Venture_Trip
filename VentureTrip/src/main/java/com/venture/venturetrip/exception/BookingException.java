package com.venture.venturetrip.exception;

public class BookingException extends RuntimeException {
    public BookingException() {
    }

    public BookingException(String message) {
        super(message);
    }
}
