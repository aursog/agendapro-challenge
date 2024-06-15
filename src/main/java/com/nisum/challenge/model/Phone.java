package com.nisum.challenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Phone extends BaseEntityAudit {
  @Column(name = "phone_number")
  private String number;
  @Column
  private String citycode;
  @Column
  private String countrycode;
  @ManyToOne
  private User user;
}
