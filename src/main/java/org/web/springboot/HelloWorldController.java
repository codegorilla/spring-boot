package org.web.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

  @GetMapping("/")
  public String helloWorld() {
    return "index";
  }

  @GetMapping("/goodbye")
  public String goodbyeWorld() {
    return "Goodbye from Spring Boot!";
  }

}
