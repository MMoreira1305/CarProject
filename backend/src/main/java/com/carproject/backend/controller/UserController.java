package com.carproject.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carproject.backend.model.User;
import com.carproject.backend.serv.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{username}")
    public String getUser(@PathVariable String username) {
        return username;
    }

    @PostMapping("/")
    public ResponseEntity setUser(@RequestBody User user) {
        var userDTO = new UserService().post(user);
        return ResponseEntity.ok(userDTO);
    }
}
