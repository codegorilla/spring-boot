package org.web.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RegistrationForm {

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @NotBlank
  @Email
  private String emailAddress;

  @NotBlank
  private String organization;

  // the dropdown submits the ID, not the entity

  @NotNull
  private Long departmentId;
}
