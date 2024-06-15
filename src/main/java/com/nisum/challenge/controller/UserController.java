package com.nisum.challenge.controller;

import com.nisum.challenge.dto.UserDto;
import com.nisum.challenge.service.UserService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping()
  public ResponseEntity<List<UserDto>> getListUsers() {
    return ResponseEntity.ok(this.userService.list());
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<UserDto> getUserByUuid(@PathVariable UUID uuid) {
    return ResponseEntity.ok(this.userService.get(uuid));
  }
}
