package com.agendapro.challenge.service;

import com.agendapro.challenge.dto.request.AuthRequest;
import com.agendapro.challenge.dto.request.UserRequest;
import com.agendapro.challenge.dto.response.UserResponse;

public interface AuthenticationService {
  UserResponse create(UserRequest userRequest);

  UserResponse authenticate(AuthRequest authRequest);
}
