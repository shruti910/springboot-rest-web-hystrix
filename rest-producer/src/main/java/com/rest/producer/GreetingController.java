package com.rest.producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	 @GetMapping("/greeting/{username}")
    public String greeting(@PathVariable("username") String username) {
        return String.format("Hello %s!%n", username);
    }

}
