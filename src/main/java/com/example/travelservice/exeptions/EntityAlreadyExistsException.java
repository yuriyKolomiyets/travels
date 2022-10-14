package com.example.travelservice.exeptions;

public class EntityAlreadyExistsException extends RuntimeException {

        public EntityAlreadyExistsException() {
            super();
        }

    public EntityAlreadyExistsException(String message) {
            super(message);
        }

    public EntityAlreadyExistsException(String message, Throwable cause) {
            super(message, cause);
        }
    }
