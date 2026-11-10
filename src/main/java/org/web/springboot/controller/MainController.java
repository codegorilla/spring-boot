package org.web.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.web.springboot.service.ProductService;

@Controller
public class MainController {

  @Autowired
  ProductService productService;

  @GetMapping("/")
  public String helloWorld() {
    return "index";
  }

  @GetMapping("/products")
  @ResponseBody
  public String products () {
    var x = productService.getProducts();
    System.out.println(x);
    return "Here are your products!\n" +
    productService.getProducts().stream()
      .filter(product -> product.getId() > 1)
      .toList();
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
  public String dashboard() {
    return "dashboard";
  }

}
