package com.agendapro.challenge.service.impl;

import com.agendapro.challenge.dto.CategoryDto;
import com.agendapro.challenge.dto.FilterDto;
import com.agendapro.challenge.dto.ProductDto;
import com.agendapro.challenge.dto.UnidadDto;
import com.agendapro.challenge.dto.mappers.CategoryMapper;
import com.agendapro.challenge.dto.mappers.ProductMapper;
import com.agendapro.challenge.dto.mappers.UnidadMapper;
import com.agendapro.challenge.dto.request.ProductRequest;
import com.agendapro.challenge.exceptions.BadRequestException;
import com.agendapro.challenge.model.Category;
import com.agendapro.challenge.model.Product;
import com.agendapro.challenge.model.Unidad;
import com.agendapro.challenge.repository.CategoryRepository;
import com.agendapro.challenge.repository.ProductRepository;
import com.agendapro.challenge.repository.UnidadRepository;
import com.agendapro.challenge.repository.specification.ProductSpecification;
import com.agendapro.challenge.service.ProductService;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;
  private CategoryRepository categoryRepository;
  private UnidadRepository unidadRepository;

  @Override
  public List<ProductDto> list(String name) {
    return productRepository.findAll(
        ProductSpecification.columnEqual(Arrays.asList(new FilterDto("descripcion", name)))
    ).stream().map(ProductMapper::toDto).collect(Collectors.toList());
  }

  @Override
  public ProductDto getByUuid(String uuid) {
    return productRepository.findById(UUID.fromString(uuid))
        .map(ProductMapper::toDto)
        .orElseThrow(() -> new BadRequestException("Product not found by uuid: " + uuid));
  }

  @Override
  public ProductDto save(ProductRequest body) {
    Category category = categoryRepository.findById(UUID.fromString(body.category()))
        .orElseThrow(() -> new BadRequestException("Category not found by uuid: " + body.category()));
    Unidad unidad = unidadRepository.findById(UUID.fromString(body.unidad()))
        .orElseThrow(() -> new BadRequestException("Unidad not found by uuid: " + body.unidad()));

    return this.save(ProductMapper.fromRequestToEntity(body, category, unidad));
  }

  private ProductDto save(Product product) {
    return ProductMapper.toDto(productRepository.save(product));
  }

  @Override
  public void delete(String uuid) {
    productRepository.delete(
        productRepository.findById(UUID.fromString(uuid))
        .orElseThrow(() -> new BadRequestException("Product not found by uuid: " + uuid))
    );
  }

  @Override
  public ProductDto update(String uuid, ProductRequest body) {
    CategoryDto category = categoryRepository.findById(UUID.fromString(body.category()))
        .map(CategoryMapper::toDto)
        .orElse(null);
    UnidadDto unidad = unidadRepository.findById(UUID.fromString(body.unidad()))
        .map(UnidadMapper::toDto)
        .orElse(null);

    ProductDto productDto = ProductDto.updater(this.getByUuid(uuid))
        .sku(body.sku())
        .descripcion(body.descripcion())
        .category(category)
        .version(body.version())
        .unidad(unidad)
        .loteable(body.loteable())
        .imagenUrl(body.imagenUrl())
        .comentario(body.comentario())
        .update();

    return this.save(ProductMapper.toEntity(productDto));
  }
}
