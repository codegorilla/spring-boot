package org.web.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

  @GetMapping("/")
  public String helloWorld() {
    return "index";
  }

  @GetMapping("/goodbye")
  @ResponseBody
  public String goodbyeWorld() {
    return "Goodbye from Spring Boot!";
  }

  @GetMapping("/login")
  public String login () {
    return "login";
  }

  @GetMapping("/dashboard")
  @ResponseBody
  public String dashboard() {
    return "dashboard";
  }

}
