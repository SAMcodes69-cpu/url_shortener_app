package com.sadbhav.urlshortener.service;

import com.sadbhav.urlshortener.enums.Role;
import com.sadbhav.urlshortener.exception.UserNotFoundException;
import com.sadbhav.urlshortener.model.User;
import com.sadbhav.urlshortener.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        if(userRepository.existsByUsername(user.getUsername())){
            throw new UserNotFoundException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(user.getRole() == null){
            user.setRole(Role.ROLE_USER);
        }
        return userRepository.save(user);
    }
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public void upgradeToPremium(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setRole(Role.ROLE_PREMIUM);
        userRepository.save(user);
    }
}
