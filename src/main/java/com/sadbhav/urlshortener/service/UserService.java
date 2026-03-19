package com.sadbhav.urlshortener.service;

import com.sadbhav.urlshortener.model.User;

import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> findByUsername(String username);
    void upgradeToPremium(String username);
}
