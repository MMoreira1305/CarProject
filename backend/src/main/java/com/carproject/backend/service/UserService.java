package com.carproject.backend.service;

import com.carproject.backend.dto.UserDTO;
import com.carproject.backend.model.User;
import com.carproject.backend.repository.UserRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.createFor(user);
            usersDTO.add(userDTO);
        }
        return usersDTO;
    }

    public User verifyUser(User user) {
        Optional<User> verifyUsername = userRepository.findByLogin(user.getLogin());
        Optional<User> verifyEmail = userRepository.findByEmail(user.getEmail());

        if (verifyUsername.isPresent() || verifyEmail.isPresent()) {
            throw new IllegalArgumentException("Usuário já cadastrado");
        }
        return user;
    }

    public UserDTO post(User user) {
        verifyUser(user);
        var passwordHashred = BCrypt.withDefaults()
                .hashToString(12, user.getPassword().toCharArray());

        user.setPassword(passwordHashred);
        userRepository.save(user);
        UserDTO userDTO = new UserDTO(user);
        return userDTO;
    }

    public ResponseEntity getById(Long id) {
        Assert.notNull(id, "Não foi encontrar pois está sem o ID");
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            UserDTO userDTO = new UserDTO(user.get());
            return ResponseEntity.ok(userDTO);
        }
        return ResponseEntity.notFound().build();

    }

    public ResponseEntity getByName(String name) {
        Assert.notNull(name, "Não foi possível atualizar o registro pois não foi passado o nome");
        List<User> users = userRepository.findByName(name);

        if (!users.isEmpty()) {
            if (users.size() < 2) {
                for (User user : users) {
                    UserDTO userDTO = new UserDTO(user);
                    return ResponseEntity.ok(userDTO);
                }
            }

            List<UserDTO> usersDTO = new ArrayList<>();

            for (User user : users) {
                UserDTO userDTO = new UserDTO(user);
                usersDTO.add(userDTO);
            }
            return ResponseEntity.ok(usersDTO);
        }
        return ResponseEntity.notFound().build();
    }

    public UserDTO updateUser(Long id, User user) {
        Assert.notNull(id, "Não foi possível atualizar o registro");

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            user.setId(userOptional.get().getId());
            post(user);
            UserDTO userDTO = new UserDTO(user);

            return userDTO;
        } else {
            throw new RuntimeException("Não foi possível localizar o carro no DBA");
        }
    }

    public void delete(Long id) {
        Assert.notNull(id, "Não foi encontrar pois está sem o ID");
        userRepository.deleteById(id);
    }
}
