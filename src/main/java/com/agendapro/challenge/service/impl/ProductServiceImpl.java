package com.agendapro.challenge.service.impl;

import com.agendapro.challenge.dto.FilterDto;
import com.agendapro.challenge.dto.ProductDto;
import com.agendapro.challenge.dto.mappers.ProductMapper;
import com.agendapro.challenge.exceptions.BadRequestException;
import com.agendapro.challenge.repository.ProductRepository;
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

  @Override
  public List<ProductDto> list(String name) {
    return productRepository.findAll(
        ProductSpecification.columnEqual(Arrays.asList(new FilterDto("descripcion", name)))
    ).stream().map(ProductMapper::toDto).collect(Collectors.toList());
  }

  @Override
  public ProductDto getByUuid(UUID uuid) {
    return productRepository.findById(uuid)
        .map(ProductMapper::toDto)
        .orElseThrow(() -> new BadRequestException("Product not found by uuid: " + uuid));
  }

}
