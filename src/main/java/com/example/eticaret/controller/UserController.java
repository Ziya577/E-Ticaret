package com.example.eticaret.controller;

import com.example.eticaret.dto.UserDto;
import com.example.eticaret.model.User;
import com.example.eticaret.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
 public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public ResponseEntity<User> addNewUser(@RequestBody @Valid UserDto userDto) {
        return userService.addNewUser(userDto);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody @Valid UserDto userDto, @PathVariable Long id) {
        return userService.updateUser(userDto, id);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/get/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);

    }
}