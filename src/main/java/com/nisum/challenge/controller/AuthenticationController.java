package com.nisum.challenge.controller;

import com.nisum.challenge.dto.request.AuthRequest;
import com.nisum.challenge.dto.request.UserRequest;
import com.nisum.challenge.dto.response.UserResponse;
import com.nisum.challenge.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
  private final AuthenticationService authenticationService;

  @PostMapping("login")
  public ResponseEntity<UserResponse> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
    return ResponseEntity.ok(authenticationService.authenticate(authRequest));
  }

  @PostMapping("signin")
  public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
    return ResponseEntity.ok(authenticationService.create(userRequest));
  }
}
