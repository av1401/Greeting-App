package com.example.greetingapp.controller;

import com.example.greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Default Greeting (Hello World)
    @GetMapping("/hello")
    public String getSimpleGreeting() {
        return greetingService.getSimpleGreeting();
    }

    //  Greeting with First Name
    @GetMapping("/firstname/{firstName}")
    public String getGreetingWithFirstName(@PathVariable String firstName) {
        return greetingService.getPersonalizedGreeting(firstName, null);
    }

    //  Greeting with Last Name
    @GetMapping("/lastname/{lastName}")
    public String getGreetingWithLastName(@PathVariable String lastName) {
        return greetingService.getPersonalizedGreeting(null, lastName);
    }

    // Greeting with Both First and Last Name
    @GetMapping("/fullname/{firstName}/{lastName}")
    public String getGreetingWithFullName(@PathVariable String firstName, @PathVariable String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }

    // Greeting using Query Parameters (Flexible way)
    @GetMapping
    public String getGreeting(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }
}
