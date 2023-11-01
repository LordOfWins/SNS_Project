package com.springstudy.webapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
  public boolean authenticate(String name, String password) {
    boolean validName = name.equalsIgnoreCase("seungjae");
    boolean validPassword = password.equalsIgnoreCase("1111");
    return validPassword && validName;
  }
}
