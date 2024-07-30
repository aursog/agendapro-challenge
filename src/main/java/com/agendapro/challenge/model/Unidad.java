package com.agendapro.challenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "unidad")
@RequiredArgsConstructor
@Getter
public class Unidad extends BaseEntityAudit {
  @Column
  private String descripcion;
  @OneToMany(mappedBy = "unidad")
  private List<Product> products;
}
