package com.example.travelservice.exeptions;

public class LocationExistsException extends RuntimeException {

        public LocationExistsException() {
            super();
        }

    public LocationExistsException(String message) {
            super(message);
        }

    public LocationExistsException(String message, Throwable cause) {
            super(message, cause);
        }
    }
