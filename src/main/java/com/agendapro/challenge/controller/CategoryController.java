package com.agendapro.challenge.controller;

import com.agendapro.challenge.dto.CategoryDto;
import com.agendapro.challenge.dto.request.CategoryRequest;
import com.agendapro.challenge.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

  private CategoryService categoryService;

  @PostMapping
  public ResponseEntity<CategoryDto> create(@RequestBody CategoryRequest request) {
    return ResponseEntity.ok(categoryService.create(request));
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<CategoryDto> getByUuid(@PathVariable("uuid") String uuid) {
    return ResponseEntity.ok(categoryService.get(uuid));
  }

  @GetMapping
  public ResponseEntity<List<CategoryDto>> list() {
    return ResponseEntity.ok(categoryService.list());
  }
}
