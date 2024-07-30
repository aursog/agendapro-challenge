package com.agendapro.challenge.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductDto (
    UUID uuid,
    String sku,
    String descripcion,
    CategoryDto category,
    String version,
    UnidadDto unidad,
    Boolean loteable,
    String imagenUrl,
    String comentario,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) { }
