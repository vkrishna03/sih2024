package com.gujarat.startup.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gujarat.startup.entity.User;
import com.gujarat.startup.repository.UserRepository;
import com.gujarat.startup.web.request.UserRequest;
import com.gujarat.startup.web.response.UserResponse;

@Service
public class UserService {

    final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    public UserResponse createUser(UserRequest userRequest) {
        if(userRequest == null || userRequest.getUsers() == null || userRequest.getUsers().isEmpty()) {
            logger.info("UserRequest is null or empty");
            return null;
        }

        UserResponse userResponse = UserResponse.builder().build();
        for(User user : userRequest.getUsers()) {
            userResponse.addUser(userRepository.save(user));
        }
        return userResponse;
    }

    public UserResponse updateUser(UserRequest userRequest) {
        return null;
    }

    public UserResponse getUserByAccountId(Long accountId) {
        if(accountId == null) {
            logger.info("AccountId is null");
            return null;
        }
        List<User> users = userRepository.findByAccountId(accountId);
        if(users == null || users.isEmpty()) {
            logger.info("Users arr not found for accountId: " + accountId);
            return null;
        }
        UserResponse userResponse = UserResponse.builder().build();
        for(User user : users) {
            userResponse.addUser(user);
        }
        return userResponse;
    }

    public UserResponse getUserById(Long userId) {
        if(userId == null) {
            logger.info("UserId is null");
            return null;
        }

        User user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            logger.info("User not found for userId: " + userId);
            return null;
        }

        UserResponse userResponse = UserResponse.builder().build();
        userResponse.addUser(user);
        return userResponse;
    }

    public UserResponse deleteByUserId(Long userId) {
        if(userId == null) {
            logger.info("UserId is null");
            return null;
        }

        User user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            logger.info("User not found for userId: " + userId);
            return null;
        }
        UserResponse userResponse = UserResponse.builder().build();
        userResponse.addUser(user);
        userRepository.deleteById(userId);
        return null;
    }
}
