package com.hplearn.user_management_service.service;

import com.hplearn.user_management_service.entity.User;
import com.hplearn.user_management_service.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User create(User user) {
        user.setPassword(encryptPassword(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findOne(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public User findByLogin(String username, String password) {
        val user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        if (comparePassword(password, user.getPassword())) {
            return user;
        }
        throw new EntityNotFoundException("Invalid credentials");
    }

    @Override
    public User findOrders(Long userId) {
        return userRepository.findUserWithOrders(userId)
                .orElseThrow(() -> new EntityNotFoundException("User or orders not found"));
    }

    @Override
    @Transactional
    public User update(User user) {
        val existingUser = findOne(user.getUserId());
        existingUser.setUsername(user.getUsername());
        return userRepository.save(existingUser);
    }

    @Override
    @Transactional
    public User updatePassword(User user) {
        val existingUser = findOne(user.getUserId());
        existingUser.setPassword(encryptPassword(user.getPassword()));
        return userRepository.save(existingUser);
    }

    private String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    private boolean comparePassword(String input, String stored) {
        return passwordEncoder.matches(input, stored);
    }
}
