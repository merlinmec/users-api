package com.mecdev.users_api.controller;

import com.mecdev.users_api.models.entity.User;
import com.mecdev.users_api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> getUserById(@RequestParam Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserById(@RequestParam Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

}
