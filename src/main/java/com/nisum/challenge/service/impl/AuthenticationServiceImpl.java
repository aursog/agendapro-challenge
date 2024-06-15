package com.nisum.challenge.service.impl;

import com.nisum.challenge.dto.mappers.UserMapper;
import com.nisum.challenge.dto.request.AuthRequest;
import com.nisum.challenge.dto.request.UserRequest;
import com.nisum.challenge.dto.response.UserResponse;
import com.nisum.challenge.service.AuthenticationService;
import com.nisum.challenge.service.JwtService;
import com.nisum.challenge.service.UserService;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
  public UserResponse authenticate(AuthRequest authRequest) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            authRequest.getUsername(),
            authRequest.getPassword()
        )
    );

    return UserMapper.fromEntityToResponse(
        userService.loadUserByUsername(authRequest.getUsername()),
        jwtService.generateToken(authRequest.getUsername()));
  }
}
