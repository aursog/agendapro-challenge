package com.agendapro.challenge.dto.mappers;

import com.agendapro.challenge.dto.ProductDto;
import com.agendapro.challenge.model.Product;

public class ProductMapper {

  public static ProductDto toDto(Product entity) {
    return new ProductDto(
        entity.getUuid(),
        entity.getSku(),
        entity.getDescripcion(),
        CategoryMapper.toDto(entity.getCategoria()),
        entity.getVersion(),
        UnidadMapper.toDto(entity.getUnidad()),
        entity.getLoteable(),
        entity.getImagenUrl(),
        entity.getComentario(),
        entity.getCreatedAt(),
        entity.getUpdatedAt()
    );
  }
}
