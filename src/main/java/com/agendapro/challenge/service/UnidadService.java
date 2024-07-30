package com.agendapro.challenge.service;

import com.agendapro.challenge.dto.UnidadDto;
import com.agendapro.challenge.dto.request.UnidadRequest;
import java.util.List;

public interface UnidadService {
  List<UnidadDto> list();
  UnidadDto get(String uuid);
  UnidadDto create(UnidadRequest request);
}
