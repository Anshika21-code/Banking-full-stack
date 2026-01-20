package com.banking.backend.service.impl;

import com.banking.backend.model.entity.User;
import com.banking.backend.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.banking.backend.service.UserService;

import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Email & password regex (FROM YOUR CODE)
    private static final Pattern EMAIL_RE =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern PASSWORD_RE =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$");

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        if (!EMAIL_RE.matcher(user.getEmail()).matches()) {
            throw new RuntimeException("Invalid email format");
        }

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        if (!PASSWORD_RE.matcher(user.getPassword()).matches()) {
            throw new RuntimeException("Weak password");
        }

        // BCrypt hashing (FROM YOUR CODE)
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));

        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email not found"));

        if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}