package com.nisum.challenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users", indexes = {
    @Index(name = "idx_email", columnList = "email"),
    @Index(name = "idx_name", columnList = "name")
})
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class User extends BaseEntityAudit {
  @Column
  private String name;
  @Column
  private String email;
  @Column
  private String password;
  @OneToMany
  private List<Phone> phones;
  @Column(name = "access_date")
  private LocalDateTime accessDate;
  @Column(name = "is_active")
  private Boolean isActive;
  @Column(name = "roles", nullable = false, length = 500)
  private String roles = "ROLE_ADMIN";
}
