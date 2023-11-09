package com.carproject.backend.serv;

import com.carproject.backend.model.User;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String gerarToken(User usuario) {
        return com.auth0.jwt.JWT.create()
                .withIssuer("Carros")
                .withSubject(usuario.getUsername())
                .withClaim("id", usuario.getId())
                .withExpiresAt(LocalDateTime.now()
                        .plusDays(1)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("api-security-java"));
    }


    public String getSubject(String token) {
        return com.auth0.jwt.JWT.require(Algorithm.HMAC256("api-security-java"))
                .withIssuer("Carros")
                .build().verify(token)
                .getSubject();
    }
}
