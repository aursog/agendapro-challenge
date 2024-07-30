package com.agendapro.challenge.service;

import com.agendapro.challenge.dto.UserDto;
import com.agendapro.challenge.dto.request.UserRequest;
import com.agendapro.challenge.model.User;
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
