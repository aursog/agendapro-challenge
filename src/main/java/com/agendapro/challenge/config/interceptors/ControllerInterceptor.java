package com.agendapro.challenge.config.interceptors;

import com.agendapro.challenge.exceptions.BadRequestException;
import com.agendapro.challenge.exceptions.ForbiddenRequestException;
import com.agendapro.challenge.exceptions.EmailExistsException;
import com.agendapro.challenge.exceptions.PasswordValidationException;
import com.agendapro.challenge.model.BaseErrorModel;
import jakarta.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerInterceptor {
  private static final Logger log = LoggerFactory.getLogger(ControllerInterceptor.class);

  private HttpServletRequest request;

  public ControllerInterceptor(HttpServletRequest request) {
    this.request = request;
  }

  @ExceptionHandler(BadRequestException.class)
  protected ResponseEntity badRequestException(BadRequestException e) {
    return ResponseEntity
        .badRequest()
        .body(createError(e, e.getValue()));
  }

  @ExceptionHandler(BadCredentialsException.class)
  protected ResponseEntity badCredentialsException(BadCredentialsException e) {
    return ResponseEntity
        .badRequest()
        .body(createError(e, e.getMessage()));
  }

  @ExceptionHandler(ForbiddenRequestException.class)
  protected ResponseEntity forbiddenRequestException(ForbiddenRequestException e) {
    return ResponseEntity
        .status(HttpStatus.FORBIDDEN)
        .body(createError(e, e.getMessage(), HttpStatus.FORBIDDEN.value()));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
    //Get all errors
    List<String> errors = e.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(x -> x.getObjectName() + "." + x.getField() + " " + x.getDefaultMessage())
        .sorted()
        .collect(Collectors.toList());

    return ResponseEntity
        .badRequest()
        .body(createError(e, errors));
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  protected ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException e) {
    return ResponseEntity
        .badRequest()
        .body(createError(e, e.getMessage()));
  }

  @ExceptionHandler(EmailExistsException.class)
  protected ResponseEntity emailExistException(EmailExistsException e) {
    return ResponseEntity.badRequest().body(createError(e, e.getMessage()));
  }

  @ExceptionHandler(PasswordValidationException.class)
  protected ResponseEntity passwordValidationException(PasswordValidationException e) {
    return ResponseEntity.badRequest().body(createError(e, e.getMessage()));
  }

  private BaseErrorModel createError(Exception exception, Object errorMessage) {
    return createError(exception, errorMessage, HttpStatus.BAD_REQUEST.value());
  }

  private BaseErrorModel createError(Exception exception, Object errorMessage, Integer status) {
    log.error("Caught {} with message : {}", exception.getClass().getSimpleName(), errorMessage);
    return new BaseErrorModel(ZonedDateTime.now(), status, errorMessage, request.getContextPath() + request.getServletPath());
  }
}
