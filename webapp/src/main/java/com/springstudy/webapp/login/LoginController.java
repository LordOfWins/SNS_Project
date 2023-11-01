package com.springstudy.webapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

  private final AuthenticationService authenticationService;

  public LoginController(AuthenticationService authenticationService) {
    super();
    this.authenticationService = authenticationService;
  }

  @RequestMapping(value = "login", method = RequestMethod.GET)
  public String loginPage() {
    return "login";
  }

  @RequestMapping(value = "login", method = RequestMethod.POST)
  public String welcomePage(String name, String password, ModelMap model) {
    if (authenticationService.authenticate(name, password)) {
      model.put("name", name);
      return "welcome";
    }
    model.put("error", "Wrong name or password");
    return "login";
  }
}
