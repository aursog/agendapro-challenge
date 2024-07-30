package com.agendapro.challenge.dto.mappers;

import com.agendapro.challenge.dto.PhoneDto;
import com.agendapro.challenge.model.Phone;

public class PhoneMapper {

  public static PhoneDto toDto(Phone entity) {
    return new PhoneDto(entity.getNumber(), entity.getCitycode(), entity.getCountrycode());
  }

}
