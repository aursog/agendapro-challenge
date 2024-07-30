package com.agendapro.challenge.dto;

import java.util.UUID;

public record CategoryDto (
    UUID uuid,
    String description
){ }
