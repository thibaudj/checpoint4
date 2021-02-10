package com.checkpoint4.api.exceptions;

public class UserNotFoundException extends RessourceNotFoundException {
    public UserNotFoundException() {
        super("The User you asked for doesn't exist or is not found");
    }
}
