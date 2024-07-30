package com.agendapro.challenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "product",
    indexes = @Index(name = "idx_sku", columnList = "sku")
)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntityAudit {
  @Column
  private String sku;
  @Column
  private String descripcion;
  @JoinColumn(name = "category_uuid", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  private Category categoria;
  @Column
  private String version;
  @JoinColumn(name = "unidad_uuid", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  private Unidad unidad;
  @Column
  private Boolean loteable;
  @Column(name = "imagen_url")
  private String imagenUrl;
  @Column
  private String comentario;
}
