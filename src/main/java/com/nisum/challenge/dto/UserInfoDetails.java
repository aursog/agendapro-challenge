package com.nisum.challenge.dto;

import com.nisum.challenge.model.User;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfoDetails implements UserDetails {

  private String username;
  private String passwd;
  private String roles;
  private User user;

  public UserInfoDetails(User user) {
    this.username = user.getEmail();
    this.passwd = user.getPassword();
    this.roles = user.getRoles();
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
    String rolesString = this.roles;
    if (rolesString != null && !rolesString.isEmpty()) {
      String[] roleNames = rolesString.split(",");
      for (String roleName : roleNames) {
        String trimmedRole = roleName.trim();
        if (!trimmedRole.isEmpty()) {
          authorities.add(new SimpleGrantedAuthority(trimmedRole));
        }
      }
    }
    return authorities;
  }

  @Override
  public String getPassword() {
    return this.passwd;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public User getUser() {
    return this.user;
  }
}
