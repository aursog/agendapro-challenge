package com.agendapro.challenge.dto.request;

public record ProductRequest (
  String sku,
  String descripcion,
  String category,
  String version,
  String unidad,
  Boolean loteable,
  String imagenUrl,
  String comentario
) { }
