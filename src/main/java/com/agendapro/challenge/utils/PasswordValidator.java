package com.agendapro.challenge.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {
  @Value("${password.regex}")
  private String passwordRegexp;

  public Boolean validatePassword(String password) {
    Pattern pattern = Pattern.compile(passwordRegexp);
    Matcher matcher = pattern.matcher(password);

    return matcher.matches();
  }
}
