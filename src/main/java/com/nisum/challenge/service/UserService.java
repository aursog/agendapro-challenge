package com.nisum.challenge.service;

import com.nisum.challenge.dto.UserDto;
import com.nisum.challenge.dto.request.UserRequest;
import com.nisum.challenge.dto.response.UserResponse;
import com.nisum.challenge.model.User;
import java.util.List;
import java.util.UUID;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

  User create(UserRequest userRequest);
  List<UserDto> list();
  UserDto get(UUID uuid);
  UserDetailsService userDetailsService();
  User loadUserByUsername(String username);
}
