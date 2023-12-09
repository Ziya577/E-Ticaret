package com.example.eticaret.service;

import com.example.eticaret.dto.UserDto;
import com.example.eticaret.exceptions.UserNotFoundException;
import com.example.eticaret.model.User;
import com.example.eticaret.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;

        this.modelMapper = modelMapper;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> addNewUser(UserDto userDto) {
        return ResponseEntity.ok(userRepository.save(modelMapper.map(userDto, User.class)));
    }

    public ResponseEntity<User> updateUser(UserDto userDto, Long id) {
        Optional<User> byId = userRepository.findById(id);

        if (byId.isPresent()) {
            User user = byId.get();
            user.setName(userDto.getName());
            user.setSurname(userDto.getSurname());
            user.setEmail(userDto.getEmail());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setBalance(userDto.getBalance());



            return ResponseEntity.ok(userRepository.save(user));
        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("user not found"));
    }


}
