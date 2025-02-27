package com.example.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    // Returns a simple "Hello World" greeting
    public String getSimpleGreeting() {
        return "Hello World";
    }

    // Returns greeting based on user input
    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            return "Hello, " + lastName + "!";
        } else {
            return getSimpleGreeting(); // Default "Hello World"
        }
    }
}
