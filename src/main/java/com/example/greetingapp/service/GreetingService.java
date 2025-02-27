package com.example.greetingapp.service;

import com.example.greetingapp.model.GreetingEntity;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // UC 4 - Save Greeting
    public GreetingEntity saveGreeting(String firstName, String lastName) {
        String message;
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            message = "Hello " + firstName + " " + lastName;
        } else if (firstName != null && !firstName.isEmpty()) {
            message = "Hello " + firstName;
        } else if (lastName != null && !lastName.isEmpty()) {
            message = "Hello " + lastName;
        } else {
            message = "Hello World";
        }
        return greetingRepository.save(new GreetingEntity(message));
    }

    // UC 5 - Find Greeting by ID
    public Optional<GreetingEntity> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // UC 6 - Fetch All Greetings
    public List<GreetingEntity> getAllGreetings() {
        return greetingRepository.findAll();
    }
}
