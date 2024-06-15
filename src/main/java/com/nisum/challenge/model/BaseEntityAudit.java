package com.nisum.challenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
@Getter
public abstract class BaseEntityAudit extends BaseEntity implements Serializable {

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BaseEntityAudit)) return false;
    if (!super.equals(o)) return false;
    BaseEntityAudit that = (BaseEntityAudit) o;
    return createdAt.equals(that.createdAt) &&
        updatedAt.equals(that.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(),
        createdAt, updatedAt);
  }

  @Override
  public String toString() {
    return "BaseEntityAudit{" +
    ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        "}" +
        super.toString();
  }
}
