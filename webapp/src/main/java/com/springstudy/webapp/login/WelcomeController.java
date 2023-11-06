package com.springstudy.webapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String welcomePage(ModelMap modelMap) {
    modelMap.put("name", getLoggedInUserName());
    return "welcome";
  }

  // 하드코딩 된 아이디 바꾸기
  private String getLoggedInUserName() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return authentication.getName();
  }
}
