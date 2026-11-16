package org.web.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.web.springboot.service.UserService;

@Controller
public class UserController {

  private final UserService userService;

  public UserController (UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public String getUsers (Model model) {
    model.addAttribute("users", userService.getUsers());
    return "users/list";
  }

  @GetMapping("/users/{id}")
  public String getUser (@PathVariable Long id, Model model) {
    model.addAttribute("user", userService.getUser(id));
    return "users/details";
  }

}
