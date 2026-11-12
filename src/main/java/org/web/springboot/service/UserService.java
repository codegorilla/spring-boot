package org.web.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web.springboot.model.Department;
import org.web.springboot.model.User;
import org.web.springboot.repository.DepartmentRepository;
import org.web.springboot.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

  private final DepartmentRepository departmentRepository;
  private final UserRepository userRepository;

  public UserService (DepartmentRepository departmentRepository, UserRepository userRepository) {
    this.userRepository = userRepository;
    this.departmentRepository = departmentRepository;
  }

  // TBD: Do some error handling including using orElseThrow

  public User registerUser (User user) {
    Department dept = departmentRepository.findById(user.getDepartmentId()).get();
    user.setDepartment(dept);
    return userRepository.save(user);
  }

  public List<User> getUsers () {
    return userRepository.findAll();
  }

}
