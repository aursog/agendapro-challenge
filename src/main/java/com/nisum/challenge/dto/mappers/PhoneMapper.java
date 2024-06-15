package com.nisum.challenge.dto.mappers;

import com.nisum.challenge.dto.PhoneDto;
import com.nisum.challenge.model.Phone;

public class PhoneMapper {

  public static PhoneDto toDto(Phone entity) {
    return new PhoneDto(entity.getNumber(), entity.getCitycode(), entity.getCountrycode());
  }

}
