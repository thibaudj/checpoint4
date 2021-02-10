package com.checkpoint4.api.exceptions;

public class SubscriptionNotFoundException extends RessourceNotFoundException {
    public SubscriptionNotFoundException() {
        super("The subscription you asked for doesn't exist or is not found");
    }
}
