package org.web.springboot.service;

import org.springframework.stereotype.Service;
import org.web.springboot.dto.UserRegistrationForm;
import org.web.springboot.model.User;
import org.web.springboot.model.UserProfile;
import org.web.springboot.repository.DepartmentRepository;
import org.web.springboot.repository.UserRepository;

@Service
public class RegistrationService {

  private final UserRepository userRepository;
  private final DepartmentRepository departmentRepository;

  public RegistrationService (UserRepository userRepository, DepartmentRepository departmentRepository) {
    this.userRepository = userRepository;
    this.departmentRepository = departmentRepository;
  }

  public User register (UserRegistrationForm form) {
    var department = departmentRepository
      .findById(form.getDepartmentId())
      .orElseThrow(() -> new IllegalArgumentException("Unknown department"));

    var userProfile = new UserProfile();
    userProfile.setOrganization(form.getOrganization());
    userProfile.setDepartment(department);

    var user = new User();
    user.setFirstName(form.getFirstName());
    user.setLastName(form.getLastName());
    user.setEmailAddress(form.getEmailAddress());
    user.setUserProfile(userProfile);

    return userRepository.save(user);
  }
}
