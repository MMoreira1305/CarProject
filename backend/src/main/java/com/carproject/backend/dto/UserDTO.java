package com.carproject.backend.dto;

import com.carproject.backend.model.*;
import com.carproject.backend.repo.BrandRepository;
import com.carproject.backend.repo.CategoryRepository;
import com.carproject.backend.repo.LevelAccessRepository;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Optional;

@Data
public class UserDTO {
    private Long id;
    private String login;
    private String password;

    private String email;
    private String telefone;
    private String name;
    private String role;

    public void createFor (User user){
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.name = user.getName();
        this.role = user.getNivelAcesso().getRole();
    }


    public UserDTO (User user){
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.name = user.getName();
        this.role = user.getNivelAcesso().getRole();
    }

    public UserDTO (){

    }
}
