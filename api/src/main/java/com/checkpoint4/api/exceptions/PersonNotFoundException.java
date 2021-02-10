package com.checkpoint4.api.exceptions;

public class PersonNotFoundException extends RessourceNotFoundException {
    public PersonNotFoundException() {
        super("The person you asked for doen't exist or is not found");
    }
}
