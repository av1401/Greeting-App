package com.example.greetingapp.service;

import com.example.greetingapp.model.GreetingEntity;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    //  Returns default greeting
    public String getSimpleGreeting() {
        return "Hello World";
    }

    //  Generates a personalized greeting and saves it to the DB
    public GreetingEntity saveGreeting(String firstName, String lastName) {
        String message;
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + lastName + "!";
        } else {
            message = getSimpleGreeting(); // Default "Hello World"
        }

        GreetingEntity greeting = new GreetingEntity(message);
        return greetingRepository.save(greeting);
    }

    // Fetch all saved greetings
    public List<GreetingEntity> getAllGreetings() {
        return greetingRepository.findAll();
    }
}
