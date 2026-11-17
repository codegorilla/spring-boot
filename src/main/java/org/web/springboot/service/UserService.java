package org.web.springboot.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.web.springboot.model.Department;
import org.web.springboot.model.User;
import org.web.springboot.repository.DepartmentRepository;
import org.web.springboot.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

  // TBD: Might not need department repository
  private final DepartmentRepository departmentRepository;
  private final UserRepository userRepository;

  public UserService (DepartmentRepository departmentRepository, UserRepository userRepository) {
    this.userRepository = userRepository;
    this.departmentRepository = departmentRepository;
  }

  public User registerUser (User user) {
    return userRepository.save(user);
  }

  public List<User> getUsers () {
//    return userRepository.findAll();
    return userRepository.findAllWithProfileBy();
  }

  public User getUser (Long id) {
//    return userRepository.findById(id)
//      .orElseThrow(() -> new IllegalArgumentException("Unknown user: " + id));
    return userRepository.findWithProfileById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
  }

  public List<User> findAll() {
    return userRepository.findAllWithProfileBy();
  }

  public User findById(Long id) {
    return userRepository.findWithProfileById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
  }

}
