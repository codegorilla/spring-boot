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

  // TBD: Research what @Valid does and if it should be used
  // redirect after POST so a refresh doesn't resubmit

  @PostMapping("/register")
  public String registerUser (@Valid @ModelAttribute("form") RegistrationForm form, BindingResult result) {
    if (result.hasErrors())
      return "register";
    registrationService.register(form);
//    return "login";
    return "redirect:/register/success";
  }

}
