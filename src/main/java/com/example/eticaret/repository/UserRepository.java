package com.example.eticaret.repository;

import com.example.eticaret.dto.UserDto;
import com.example.eticaret.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


      UserDto findUsedtoById(Long id);

}
