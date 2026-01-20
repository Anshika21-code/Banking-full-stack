package com.banking.backend.service;

import com.banking.backend.model.entity.User;

public interface UserService {
    User register(User user);
    User login(String email, String password);
}
