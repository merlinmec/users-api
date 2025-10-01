package com.mecdev.users_api.service;

import com.mecdev.users_api.models.entity.User;
import com.mecdev.users_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user){
        userRepository.saveAndFlush(user);
    }

    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("No Users found with that ID " + userId));
    }

    public User getByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("No Users found with that Email " + userEmail));
    }

    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }
}
