package com.nisum.challenge.exceptions;

public class PasswordValidationException extends RuntimeException {
  public PasswordValidationException(String message) {
    super(message);
  }
}
