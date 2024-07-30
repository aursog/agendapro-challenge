package com.agendapro.challenge.service;

import com.agendapro.challenge.dto.ProductDto;
import com.agendapro.challenge.dto.request.ProductRequest;
import java.util.List;

public interface ProductService {
  List<ProductDto> list(String name);
  ProductDto getByUuid(String uuid);
  ProductDto save(ProductRequest body);
  void delete(String uuid);
  ProductDto update(String uuid, ProductRequest body);
}
