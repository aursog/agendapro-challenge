package com.nisum.challenge.service;

import com.nisum.challenge.dto.request.UserRequest;
import com.nisum.challenge.dto.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService {
  UserResponse create(UserRequest userRequest);

  UserResponse authenticate(UserRequest userRequest);
}
