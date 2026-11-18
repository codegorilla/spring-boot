package org.web.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.web.springboot.model.Role;
import org.web.springboot.service.RoleService;
import org.web.springboot.service.UserService;

import java.util.stream.Collectors;

@Controller
public class UserController {

  private final RoleService roleService;
  private final UserService userService;

  public UserController (RoleService roleService, UserService userService) {
    this.roleService = roleService;
    this.userService = userService;
  }

  @GetMapping("/users")
  public String getUsers (Model model) {
    model.addAttribute("users", userService.getUsers());
    return "users/list";
  }

  @GetMapping("/users/{id}")
  public String getUser (@PathVariable Long id, Model model) {
    var user = userService.getUser(id);
    model.addAttribute("allRoles", roleService.getRoles());
    model.addAttribute("user", user);
    model.addAttribute("selectedRoleIds",
      user.getRoles().stream().map(Role::getId).collect(Collectors.toSet()));
    return "users/details";
  }

}
