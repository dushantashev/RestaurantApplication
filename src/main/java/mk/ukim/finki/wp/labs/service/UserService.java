package mk.ukim.finki.wp.labs.service;

import mk.ukim.finki.wp.labs.model.Role;
import mk.ukim.finki.wp.labs.model.User;


import mk.ukim.finki.wp.labs.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findByUsername(String username);

    User save(String username, String password, String name, String surname, String role);

    void deleteByUsername(String username);
    User login(String username, String password);
}
