package com.agendapro.challenge.service;

import com.agendapro.challenge.dto.CategoryDto;
import com.agendapro.challenge.dto.request.CategoryRequest;
import java.util.List;

public interface CategoryService {
  List<CategoryDto> list();
  CategoryDto get(String uuid);
  CategoryDto create(CategoryRequest request);
}
