package com.nisum.challenge.service.impl;

import com.nisum.challenge.dto.mappers.UserMapper;
import com.nisum.challenge.dto.request.UserRequest;
import com.nisum.challenge.dto.response.UserResponse;
import com.nisum.challenge.model.User;
import com.nisum.challenge.service.AuthenticationService;
import com.nisum.challenge.service.JwtService;
import com.nisum.challenge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
  private final UserService userService;
  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;

  @Override
  public UserResponse create(UserRequest userRequest) {
    return UserMapper.fromEntityToResponse(
        userService.create(userRequest),
        jwtService.generateToken(userRequest.email())
    );
  }

  @Override
  public UserResponse authenticate(UserRequest userRequest) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(userRequest.email(), userRequest.password())
    );

    return UserMapper.fromEntityToResponse(
        userService.loadUserByUsername(userRequest.email()),
        jwtService.generateToken(userRequest.email()));
  }
}
