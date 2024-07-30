package com.agendapro.challenge.dto.mappers;

import com.agendapro.challenge.dto.CategoryDto;
import com.agendapro.challenge.dto.request.CategoryRequest;
import com.agendapro.challenge.model.Category;

public final class CategoryMapper {

  public static CategoryDto toDto(Category entity) {
    return new CategoryDto(
        entity.getUuid(),
        entity.getDescripcion()
    );
  }

  public static Category toEntity(CategoryDto dto) {
    Category entity = Category.builder()
        .descripcion(dto.description())
        .build();
    entity.setUuid(dto.uuid());
    return entity;
  }

  public static Category fromRequestToEntity(CategoryRequest request) {
    return Category.builder().descripcion(request.descripcion()).build();
  }
}
