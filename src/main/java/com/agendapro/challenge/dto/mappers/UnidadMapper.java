package com.agendapro.challenge.dto.mappers;

import com.agendapro.challenge.dto.UnidadDto;
import com.agendapro.challenge.model.Unidad;

public class UnidadMapper {

  public static UnidadDto toDto(Unidad entity) {
    return new UnidadDto(
        entity.getUuid(),
        entity.getDescripcion(),
        entity.getCreatedAt(),
        entity.getUpdatedAt()
    );
  }
}
