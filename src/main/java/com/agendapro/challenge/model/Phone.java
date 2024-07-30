package com.agendapro.challenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
