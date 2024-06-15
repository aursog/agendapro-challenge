package com.nisum.challenge.service;

import com.nisum.challenge.dto.request.UserRequest;
import com.nisum.challenge.dto.response.UserResponse;
import com.nisum.challenge.model.User;
import java.util.List;
import java.util.UUID;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

  User createUser(UserRequest userRequest);
  List<UserResponse> getUser();
  UserResponse getUser(UUID uuid);
  UserDetailsService userDetailsService();
  User loadUserByUsername(String username);
}
