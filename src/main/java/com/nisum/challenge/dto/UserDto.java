package com.nisum.challenge.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record UserDto (
    UUID uuid,
    String name,
    String email,
    List<PhoneDto> phones,
    LocalDateTime lastLogin,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    Boolean isActive
) { }
