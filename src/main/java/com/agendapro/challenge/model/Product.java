package com.agendapro.challenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(
    name = "product",
    indexes = @Index(name = "idx_sku", columnList = "sku")
)
@Getter
@Builder
@RequiredArgsConstructor
public class Product extends BaseEntityAudit {
  @Column
  private String sku;
  @Column
  private String descripcion;
  @ManyToOne
  private Category categoria;
  @Column
  private String version;
  @ManyToOne
  private Unidad unidad;
  @Column
  private Boolean loteable;
  @Column(name = "imagen_url")
  private String imagenUrl;
  @Column
  private String comentario;
}
