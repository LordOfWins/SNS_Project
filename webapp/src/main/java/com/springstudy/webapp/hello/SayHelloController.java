package com.springstudy.webapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
  @RequestMapping("hello")
  @ResponseBody
  public String hello() {
    return "Hello! What are you learning today?";
  }

  @RequestMapping("hello-html")
  @ResponseBody
  public String helloHtml() {
    return "<html>"
        + "<head>"
        + "<title>HTML page - Changed</title>"
        + "</head>"
        + "</body>"
        + "<h1>Hello! What are you learning today? Changed</h1>"
        + "</body>"
        + "</html>";
  }

  // "hello-jsp" => "hello.jsp"
  @RequestMapping("hello-jsp")
  public String helloJsp() {
    return "hello";
  }
}
