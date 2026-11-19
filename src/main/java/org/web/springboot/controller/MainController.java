package org.web.springboot.controller;
import org.web.springboot.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@Controller
public class MainController {

  @Autowired
  ProductService productService;

  @GetMapping("/")
  public String helloWorld() {
    return "index";
  }

  @GetMapping("/goodbye")
  @ResponseBody
  public String goodbyeWorld() {
    return "Goodbye from Spring Boot!";
  }

  // TBD: Move to login controller

  @GetMapping("/login")
  public String login () {
    return "login";
  }

  @GetMapping("/dashboard")
  public String dashboard (Model model) {
    model.addAttribute("products", productService.getProducts());
    return "dashboard";
  }

}
