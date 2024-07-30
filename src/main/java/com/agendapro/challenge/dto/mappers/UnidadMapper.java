package com.agendapro.challenge.dto.mappers;

import com.agendapro.challenge.dto.UnidadDto;
import com.agendapro.challenge.dto.request.UnidadRequest;
import com.agendapro.challenge.model.Unidad;

public class UnidadMapper {

  public static UnidadDto toDto(Unidad entity) {
    return new UnidadDto(
        entity.getUuid(),
        entity.getDescripcion()
    );
  }

  public static Unidad toEntity(UnidadDto dto) {
    Unidad entity = Unidad.builder()
        .descripcion(dto.description())
        .build();
    entity.setUuid(dto.uuid());
    return entity;
  }

  public static Unidad fromRequestToEntity(UnidadRequest request) {
    return Unidad.builder().descripcion(request.descripcion()).build();
  }
}
