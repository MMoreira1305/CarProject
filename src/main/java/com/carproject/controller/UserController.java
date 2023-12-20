package com.carproject.controller;

import com.carproject.model.LevelAccess;
import com.carproject.repository.LevelAccessRepository;
import com.carproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carproject.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    LevelAccessRepository levelAccessRepository;

    @Autowired
    UserService userService;

    @GetMapping("/{username}")
    public String getUser(@PathVariable String username) {
        return username;
    }

    @Secured(value = "admin")
    @PostMapping
    public ResponseEntity setUser(@RequestBody User user) {
        Long levelAccessId = user.getNivelAcesso().getId();
        LevelAccess levelAccess = levelAccessRepository.findById(levelAccessId)
                .orElseThrow(() -> new IllegalArgumentException("LevelAccess não encontrado com o ID: " + levelAccessId));

        user.setNivelAcesso(levelAccess); // Define o LevelAccess no User

        var userDTO = userService.post(user);
        return ResponseEntity.ok(userDTO);
    }

    @Secured(value = "admin")
    @PostMapping("/nivelAcesso")
    public ResponseEntity setAccessLevel(@RequestBody LevelAccess levelAccess){
        levelAccessRepository.save(levelAccess);
        return ResponseEntity.ok().build();
    }

    @Secured(value = "admin")
    @GetMapping("/nivelAcesso")
    public ResponseEntity getAccessLevel(){
        return ResponseEntity.ok(levelAccessRepository.findAll());
    }
}
