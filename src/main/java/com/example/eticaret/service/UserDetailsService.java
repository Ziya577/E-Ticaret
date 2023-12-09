package com.example.eticaret.service;

import com.example.eticaret.dto.UserDetailsDto;
import com.example.eticaret.dto.UserDto;
import com.example.eticaret.exceptions.UserDetailsNotFoundException;
import com.example.eticaret.model.User;
import com.example.eticaret.model.UserDetails;
import com.example.eticaret.repository.UserDetailsRepository;
import com.example.eticaret.request.CreateUserDetailsRequest;
import com.example.eticaret.request.UpdateUserDetailsRequest;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



@Service
public class UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;


    public UserDetailsService(UserDetailsRepository userDetailsRepository, UserService userService, ModelMapper modelMapper) {
        this.userDetailsRepository = userDetailsRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    public UserDetailsDto createUser( CreateUserDetailsRequest request) {
        User user = userService.findById(request.getId());


        UserDetails userDetails = new UserDetails(
                request.getAddress(),
                request.getGender(),
                request.getBirthDate(),
                request.getPostCode(), user);

        UserDetails savedUserDetails = userDetailsRepository.save(userDetails);

        UserDetailsDto userDetailsDto = modelMapper.map(savedUserDetails, UserDetailsDto.class);

        return userDetailsDto;


    }

    public UserDetailsDto updateUser(Long userDetailsId, UpdateUserDetailsRequest request) {
        UserDetails userDetails = findUserById(userDetailsId);


        UserDetails updateUserDetails = new UserDetails(
                userDetails.getId(),
                request.getAddress(),
                request.getGender(),
                request.getBirthDate(),
                request.getPostCode(),userDetails.getUser());

        UserDetails savedUserDetails = userDetailsRepository.save(updateUserDetails);

        UserDetailsDto map = modelMapper.map(savedUserDetails, UserDetailsDto.class);

        return map;
    }


    public UserDetails findUserById(Long id){
        return userDetailsRepository.findById(id)
                .orElseThrow(()->new UserDetailsNotFoundException("User details not found"));

    }

    public void deleUserDetails(Long id) {
        userDetailsRepository.deleteById(id);
    }
}