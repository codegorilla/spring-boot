package org.web.springboot.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.web.springboot.dto.RegistrationForm;
import org.web.springboot.service.DepartmentService;
import org.web.springboot.service.RegistrationService;

@Controller
public class RegistrationController {

  private final DepartmentService departmentService;
  private final RegistrationService registrationService;

  public RegistrationController (DepartmentService departmentService, RegistrationService registrationService) {
    this.departmentService = departmentService;
    this.registrationService = registrationService;
  }

  @GetMapping("/register")
  public String registerForm (Model model) {
    model.addAttribute("form", new RegistrationForm());
    model.addAttribute("departments", departmentService.getDepartments());
    return "register";
  }
  
  @PostMapping("/register")
  public String registerUser (@Valid @ModelAttribute("form") RegistrationForm form, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("departments", departmentService.getDepartments());
      System.out.println(result.hasErrors());
      System.out.println("GOT HERE ERRORS TRUE");
      return "register";
    }
    registrationService.register(form);
    // Redirect after POST so a refresh doesn't resubmit
    return "redirect:/register/success";
  }

  @GetMapping("/register/success")
  public String showSuccess (Model model) {
    return "register-success";
  }

}
