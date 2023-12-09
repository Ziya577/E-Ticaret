package com.example.eticaret.controller;

import com.example.eticaret.dto.UserDetailsDto;
import com.example.eticaret.request.CreateUserDetailsRequest;
import com.example.eticaret.request.UpdateUserDetailsRequest;
import com.example.eticaret.service.UserDetailsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/details")
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/create")
    public UserDetailsDto createUser(@RequestBody  @Valid CreateUserDetailsRequest request){
        return userDetailsService.createUser(request);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDetailsDto> updateUser(@PathVariable Long id,@RequestBody @Valid UpdateUserDetailsRequest request){
        return ResponseEntity.ok(userDetailsService.updateUser(id,request));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserDetails(@PathVariable Long id){
        userDetailsService.deleUserDetails(id);
        return ResponseEntity.ok().build();



}

}
