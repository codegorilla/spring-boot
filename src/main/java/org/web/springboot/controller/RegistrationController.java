package org.web.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.web.springboot.model.User;
import org.web.springboot.repository.DepartmentRepo;
import org.web.springboot.service.UserService;

@Controller
public class RegistrationController {

  private final DepartmentRepo departmentRepo;

  @Autowired
  UserService userService;

  public RegistrationController(DepartmentRepo repo) {
    this.departmentRepo = repo;
  }

  @GetMapping("/register")
  public String registerForm (Model model) {
    model.addAttribute("user", new User());
    model.addAttribute("departments", departmentRepo.findAll());
    return "register";
  }

//  @PostMapping("/register")
//  public String registerUser () {
//    return "register";
//  }

}
