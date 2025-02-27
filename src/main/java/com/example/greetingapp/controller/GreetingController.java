package com.example.greetingapp.controller;

import com.example.greetingapp.model.GreetingEntity;
import com.example.greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    /*
    // UC 1 - UC 6 (Commented Out)

    // UC 4 - Save Greeting
    @PostMapping("/save")
    public GreetingEntity saveGreeting(@RequestParam(required = false) String firstName,
                                       @RequestParam(required = false) String lastName) {
        return greetingService.saveGreeting(firstName, lastName);
    }

    // UC 5 - Find Greeting by ID
    @GetMapping("/{id}")
    public Optional<GreetingEntity> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // UC 6 - List All Greetings
    @GetMapping("/all")
    public List<GreetingEntity> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
    */

    // UC 7 - Edit Greeting Message
    @PutMapping("/edit/{id}")
    public Optional<GreetingEntity> updateGreeting(@PathVariable Long id,
                                                   @RequestParam String message) {
        return greetingService.updateGreeting(id, message);
    }

}
