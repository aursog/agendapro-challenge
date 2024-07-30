package com.agendapro.challenge.dto.request;

public record PhoneRequest(
    String number,
    String citycode,
    String countrycode
) { }
