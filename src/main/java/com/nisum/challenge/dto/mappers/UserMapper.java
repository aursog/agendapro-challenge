package com.nisum.challenge.dto.mappers;

import com.nisum.challenge.dto.request.UserRequest;
import com.nisum.challenge.dto.response.UserResponse;
import com.nisum.challenge.model.Phone;
import com.nisum.challenge.model.User;
import java.util.List;

public class UserMapper {
  public static UserResponse fromEntityToResponse(User user, String token) {
    return new UserResponse(
        user.getUuid(),
        user.getCreatedAt(),
        user.getUpdatedAt(),
        user.getAccessDate(),
        token,
        user.getIsActive()
    );
  }

  public static User fromRequestToEntity(UserRequest userRequest) {
    User user = new User();
    user.setName(userRequest.name());
    user.setEmail(userRequest.email());
    user.setPassword(userRequest.password());
    return user;
  }
}
