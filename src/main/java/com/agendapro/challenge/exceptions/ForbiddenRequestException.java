package com.agendapro.challenge.exceptions;

public class ForbiddenRequestException extends RuntimeException {
  public ForbiddenRequestException(String message) {
    super(message);
  }
}
