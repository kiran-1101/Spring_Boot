package com.kiran.user.service.controller;

import com.kiran.user.service.entities.User;
import com.kiran.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    //create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    //get user by user id
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){

        User user = userService.getUserByUserId(userId);
        return ResponseEntity.ok(user);
    }
    //get all users
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);

    }


}
