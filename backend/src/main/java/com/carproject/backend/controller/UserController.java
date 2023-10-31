package com.carproject.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {

    @GetMapping("/{username}")
    public String getUser(@PathVariable String username){
        return username;
    }
}
