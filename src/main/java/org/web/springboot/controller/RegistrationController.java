package org.web.springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.web.springboot.model.Department;
import org.web.springboot.model.User;
import org.web.springboot.repository.DepartmentRepo;
import org.web.springboot.service.UserService;

@Controller
public class RegistrationController {

  // Eventually we should probably have a department service
  private final DepartmentRepo departmentRepo;

//  @Autowired
  private final UserService userService;

  public RegistrationController (DepartmentRepo repo, UserService userService) {
    this.departmentRepo = repo;
    this.userService = userService;
  }

  @GetMapping("/register")
  public String registerForm (Model model) {
    model.addAttribute("user", new User());
    model.addAttribute("departments", departmentRepo.findAll());
    return "register";
  }

  @PostMapping("/register")
  public String registerUser (@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
    if (result.hasErrors())
      return "register";

    System.out.println("*****");
    System.out.println(user.toString());
    System.out.println("*****");

    //Department department = departmentRepo.findById(user.getDepartment().getId()).get();
    userService.registerUser(user);
    return "login";
  }

}
