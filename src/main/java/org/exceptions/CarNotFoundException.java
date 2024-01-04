package org.exceptions;

public class CarNotFoundException extends RuntimeException {
    private final String message;

    public CarNotFoundException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
