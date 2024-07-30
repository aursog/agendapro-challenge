package com.agendapro.challenge.controller;

import com.agendapro.challenge.dto.ProductDto;
import com.agendapro.challenge.dto.request.ProductRequest;
import com.agendapro.challenge.service.ProductService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

  private ProductService productService;

  @GetMapping("/{uuid}")
  public ResponseEntity<ProductDto> getProduct(@PathVariable("uuid") UUID uuid) {
    return ResponseEntity.ok(productService.getByUuid(uuid));
  }

  @PostMapping
  public ResponseEntity<ProductDto> save(@RequestBody ProductRequest body) {
    return null;
  }

  @PatchMapping("/{uuid}")
  public ResponseEntity<ProductDto> update(@RequestBody ProductRequest body, @PathVariable("uuid") UUID uuid) {
    return null;
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<ProductDto> delete(@PathVariable("uuid") UUID uuid) {
    return null;
  }

  @GetMapping
  public ResponseEntity<List<ProductDto>> getProducts(@RequestParam(name = "name", required = false) String name) {
    return ResponseEntity.ok(productService.list(name));
  }
}
