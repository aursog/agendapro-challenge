package com.nisum.challenge.model;

import java.time.ZonedDateTime;

public record BaseErrorModel(
    ZonedDateTime timestamp,
    Integer status,
    Object error,
    String path
) { }
