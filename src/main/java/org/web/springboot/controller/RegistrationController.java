package org.web.springboot.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.web.springboot.model.User;
import org.web.springboot.repository.DepartmentRepository;
import org.web.springboot.service.DepartmentService;
import org.web.springboot.service.UserService;

@Controller
public class RegistrationController {

  private final DepartmentService departmentService;
  private final UserService userService;

  public RegistrationController (DepartmentService departmentService, UserService userService) {
    this.departmentService = departmentService;
    this.userService = userService;
  }

  @GetMapping("/register")
  public String registerForm (Model model) {
    model.addAttribute("user", new User());
    model.addAttribute("departments", departmentService.getDepartments());
    return "register";
  }

  // TBD: Research what @Valid does and if it should be used

  @PostMapping("/register")
  public String registerUser (@ModelAttribute("user") User user) { //, BindingResult result, Model model) {
//    if (result.hasErrors())
//      return "register";

    System.out.println("*****");
    System.out.println("dept id is" +  user.getDepartmentId());
    System.out.println(user.toString());
    System.out.println("*****");

    //Department department = departmentRepo.findById(user.getDepartment().getId()).get();
    userService.registerUser(user);
    return "login";
  }

}
