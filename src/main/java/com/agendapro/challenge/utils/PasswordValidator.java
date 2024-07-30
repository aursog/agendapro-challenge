package com.agendapro.challenge.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {
  private static final String passwordRegexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";

  public Boolean validatePassword(String password) {
    Pattern pattern = Pattern.compile(passwordRegexp);
    Matcher matcher = pattern.matcher(password);

    return matcher.matches();
  }
}
