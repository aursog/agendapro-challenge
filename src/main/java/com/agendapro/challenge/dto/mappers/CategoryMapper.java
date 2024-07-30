package com.agendapro.challenge.dto.mappers;

import com.agendapro.challenge.dto.CategoryDto;
import com.agendapro.challenge.model.Category;

public class CategoryMapper {

  public static CategoryDto toDto(Category entity) {
    return new CategoryDto(
        entity.getUuid(),
        entity.getDescripcion(),
        entity.getCreatedAt(),
        entity.getUpdatedAt()
    );
  }
}
