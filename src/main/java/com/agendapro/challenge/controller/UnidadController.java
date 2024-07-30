package com.agendapro.challenge.controller;

import com.agendapro.challenge.dto.UnidadDto;
import com.agendapro.challenge.dto.request.UnidadRequest;
import com.agendapro.challenge.service.UnidadService;
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
@RequestMapping("/unidad")
@RequiredArgsConstructor
public class UnidadController {

  private UnidadService unidadService;

  @PostMapping
  public ResponseEntity<UnidadDto> create(@RequestBody UnidadRequest request) {
    return ResponseEntity.ok(unidadService.create(request));
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<UnidadDto> get(@PathVariable("uuid") String uuid) {
    return ResponseEntity.ok(unidadService.get(uuid));
  }

  @GetMapping
  public ResponseEntity<List<UnidadDto>> list() {
    return ResponseEntity.ok(unidadService.list());
  }
}
