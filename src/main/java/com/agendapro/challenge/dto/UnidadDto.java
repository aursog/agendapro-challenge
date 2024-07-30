package com.agendapro.challenge.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record UnidadDto (
    UUID uuid,
    String description,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) { }
