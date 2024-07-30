package com.agendapro.challenge.dto.mappers;

import com.agendapro.challenge.dto.ProductDto;
import com.agendapro.challenge.dto.request.ProductRequest;
import com.agendapro.challenge.model.Category;
import com.agendapro.challenge.model.Product;
import com.agendapro.challenge.model.Unidad;

public final class ProductMapper {

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
        entity.getComentario()
    );
  }

  public static Product toEntity(ProductDto dto) {
    Product entity = Product.builder()
        .sku(dto.sku())
        .descripcion(dto.descripcion())
        .categoria(dto.category() != null ? CategoryMapper.toEntity(dto.category()) : null)
        .version(dto.version())
        .unidad(dto.unidad() != null ? UnidadMapper.toEntity(dto.unidad()) : null)
        .loteable(dto.loteable())
        .imagenUrl(dto.imagenUrl())
        .comentario(dto.comentario())
        .build();

    entity.setUuid(dto.uuid());
    return entity;
  }

  public static Product fromRequestToEntity(ProductRequest request, Category category, Unidad unidad) {
    return Product.builder()
        .sku(request.sku())
        .descripcion(request.descripcion())
        .categoria(category)
        .version(request.version())
        .unidad(unidad)
        .loteable(request.loteable())
        .imagenUrl(request.imagenUrl())
        .comentario(request.comentario())
        .build();
  }
}
