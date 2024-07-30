package com.agendapro.challenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "category")
@Builder
@Getter
@RequiredArgsConstructor
public class Category extends BaseEntityAudit {
  @Column
  private String descripcion;
  @OneToMany(mappedBy = "categoria")
  private List<Product> products;
}
