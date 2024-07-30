package com.agendapro.challenge.service;

import com.agendapro.challenge.dto.ProductDto;
import java.util.List;
import java.util.UUID;

public interface ProductService {
  List<ProductDto> list(String name);
  ProductDto getByUuid(UUID uuid);
}
