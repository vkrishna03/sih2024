package com.gujarat.startup.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gujarat.startup.service.UserService;
import com.gujarat.startup.web.request.UserRequest;
import com.gujarat.startup.web.response.UserResponse;

@RestController
@RequestMapping("/user")
public class UserAPI {

    final Logger logger = LoggerFactory.getLogger(UserAPI.class);

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.createUser(userRequest);
        if(userResponse == null) {
            logger.info("UserResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userResponse);
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.updateUser(userRequest);
        if(userResponse == null) {
            logger.info("UserResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<UserResponse> getUserByUserId(Long userId) {
        UserResponse userResponse = userService.getUserById(userId);
        if(userResponse == null) { 
            logger.info("UserResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/userId/{userId}")
    public ResponseEntity<UserResponse> deleteUserByUserId(Long userId) {
        UserResponse userResponse = userService.deleteByUserId(userId);
        if(userResponse == null) {
            logger.info("UserResponse is null");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userResponse);
    }
}
