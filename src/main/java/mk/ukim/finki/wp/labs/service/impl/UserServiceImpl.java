package mk.ukim.finki.wp.labs.service.impl;

import mk.ukim.finki.wp.labs.model.User;

import mk.ukim.finki.wp.labs.repository.impl.UserRepository;
import mk.ukim.finki.wp.labs.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findById(username);
    }

    @Override
    public User save(String username, String password, String name, String surname, String role) {
        User user = new User(username, password, name, surname, role);
        return userRepository.save(user);
    }

    @Override
    public void deleteByUsername(String username) {
        userRepository.deleteById(username);
    }
    @Override
    public User login(String username, String password) {
        User user = userRepository.findById(username).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        if (!user.getPassword().equals(password))
            throw new RuntimeException("Invalid password");

        return user;
    }

}
