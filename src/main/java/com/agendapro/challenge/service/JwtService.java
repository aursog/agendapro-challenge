package com.agendapro.challenge.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
  String extractUserName(String token);
  String generateToken(UserDetails userDetails);
  String generateToken(String username);
  boolean isTokenValid(String token, UserDetails userDetails);
}
