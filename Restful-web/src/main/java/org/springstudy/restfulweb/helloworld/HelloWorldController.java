package org.springstudy.restfulweb.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping(path = "/hello")
  public String hello() {
    return "Hello World!";
  }

  @GetMapping(path = "/hello-world-bean")
  public HelloWorld helloWorldBean() {
    return new HelloWorld("Hello World!");
  }

  @GetMapping(path = "/hello-world/path-variable/{name}")
  public HelloWorld helloWorldPathVariable(@PathVariable String name) {
    return new HelloWorld(String.format("Hello World, %s!", name));
  }
}
