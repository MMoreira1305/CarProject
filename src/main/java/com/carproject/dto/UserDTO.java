package com.carproject.dto;

import com.carproject.CarProject.model.*;
import com.carproject.model.User;
import lombok.Data;

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
