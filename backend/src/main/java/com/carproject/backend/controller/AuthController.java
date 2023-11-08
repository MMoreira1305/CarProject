package com.carproject.backend.controller;

import com.carproject.backend.dto.Login;
import com.carproject.backend.model.User;
import com.carproject.backend.repo.UserRepository;
import com.carproject.backend.serv.TokenService;
import com.carproject.backend.serv.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String login(@RequestBody Login login){
        System.out.println("Chegou aqui");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.login(),
                        login.password());

        System.out.println("Chegou aqui");

        Authentication authenticate = this.authenticationManager.
                authenticate(usernamePasswordAuthenticationToken);

        System.out.println("Chegou aqui");

        var usuario = (User) authenticate.getPrincipal();

        System.out.println("Chegou aqui");

        return tokenService.gerarToken(usuario);

    }
}
