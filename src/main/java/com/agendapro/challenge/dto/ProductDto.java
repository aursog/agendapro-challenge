package com.agendapro.challenge.dto;

import java.util.UUID;

public record ProductDto (
    UUID uuid,
    String sku,
    String descripcion,
    CategoryDto category,
    String version,
    UnidadDto unidad,
    Boolean loteable,
    String imagenUrl,
    String comentario
) {
  public static Updater updater(ProductDto productDto) {
    return new Updater(productDto);
  }

  public static final class Updater {
    private ProductDto productDto;
    private String sku;
    private String descripcion;
    private CategoryDto category;
    private String version;
    private UnidadDto unidad;
    private Boolean loteable;
    private String imagenUrl;
    private String comentario;

    public Updater(ProductDto productDto) {
      this.productDto = productDto;
    }

    public Updater sku(String sku) {
      this.sku = sku;
      return this;
    }

    public Updater descripcion(String descripcion) {
      this.descripcion = descripcion;
      return this;
    }

    public Updater category(CategoryDto category) {
      this.category = category;
      return this;
    }

    public Updater version(String version) {
      this.version = version;
      return this;
    }

    public Updater unidad(UnidadDto unidad) {
      this.unidad = unidad;
      return this;
    }

    public Updater loteable(Boolean loteable) {
      this.loteable = loteable;
      return this;
    }

    public Updater imagenUrl(String imagenUrl) {
      this.imagenUrl = imagenUrl;
      return this;
    }

    public Updater comentario(String comentario) {
      this.comentario = comentario;
      return this;
    }

    public ProductDto update() {
      return new ProductDto(
          this.productDto.uuid,
          this.sku == null ? this.productDto.sku() : this.sku,
          this.descripcion == null ? this.productDto.descripcion() : this.descripcion,
          this.category == null ? this.productDto.category() : this.category,
          this.version == null ? this.productDto.version() : this.version,
          this.unidad == null ? this.productDto.unidad() : this.unidad,
          this.loteable == null ? this.productDto.loteable() : this.loteable,
          this.imagenUrl == null ? this.productDto.imagenUrl() : this.imagenUrl,
          this.comentario == null ? this.productDto.comentario() : this.comentario
      );
    }
  }
}
