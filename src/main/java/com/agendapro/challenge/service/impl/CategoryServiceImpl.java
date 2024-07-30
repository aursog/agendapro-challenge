package com.agendapro.challenge.service.impl;

import com.agendapro.challenge.dto.CategoryDto;
import com.agendapro.challenge.dto.mappers.CategoryMapper;
import com.agendapro.challenge.dto.request.CategoryRequest;
import com.agendapro.challenge.exceptions.BadRequestException;
import com.agendapro.challenge.repository.CategoryRepository;
import com.agendapro.challenge.service.CategoryService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private CategoryRepository categoryRepository;

  @Override
  public List<CategoryDto> list() {
    return categoryRepository.findAll()
        .stream().map(CategoryMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public CategoryDto get(String uuid) {
    return categoryRepository.findById(UUID.fromString(uuid))
        .map(CategoryMapper::toDto)
        .orElseThrow(() -> new BadRequestException("Category with uuid " + uuid + " not found"));
  }

  @Override
  public CategoryDto create(CategoryRequest request) {
    return CategoryMapper.toDto(
        categoryRepository.save(CategoryMapper.fromRequestToEntity(request))
    );
  }
}
