package com.nisum.challenge.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(
    UUID uuid,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    LocalDateTime lastLogin,
    String token,
    Boolean isActive
) { }
