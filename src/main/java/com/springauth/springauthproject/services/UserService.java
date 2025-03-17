package com.springauth.springauthproject.services;

import com.springauth.springauthproject.controllers.UserController;
import com.springauth.springauthproject.entities.User;
import com.springauth.springauthproject.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    @Transactional
    public User create(String name, String email, String rawPassword) {
        if (name == null || email == null || rawPassword == null) throw new IllegalArgumentException("Name, email and password cannot be null");
        String hashedPassword = passwordEncoder.encode(rawPassword);
        User user = new User(null, name, email, hashedPassword);
        return repository.save(user);
    }

    // Password Checker
    public boolean checkPassword(User user, String rawPassword) {
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
}
