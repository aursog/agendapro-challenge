package com.agendapro.challenge.service.impl;

import com.agendapro.challenge.dto.UnidadDto;
import com.agendapro.challenge.dto.mappers.UnidadMapper;
import com.agendapro.challenge.dto.request.UnidadRequest;
import com.agendapro.challenge.exceptions.BadRequestException;
import com.agendapro.challenge.repository.UnidadRepository;
import com.agendapro.challenge.service.UnidadService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnidadServiceImpl implements UnidadService {
  private UnidadRepository unidadRepository;

  @Override
  public List<UnidadDto> list() {
    return unidadRepository.findAll()
        .stream().map(UnidadMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public UnidadDto get(String uuid) {
    return unidadRepository.findById(UUID.fromString(uuid))
        .map(UnidadMapper::toDto)
        .orElseThrow(() -> new BadRequestException("Unidad not found with uuid: " + uuid));
  }

  @Override
  public UnidadDto create(UnidadRequest request) {
    return UnidadMapper.toDto(
        unidadRepository.save(UnidadMapper.fromRequestToEntity(request))
    );
  }
}
