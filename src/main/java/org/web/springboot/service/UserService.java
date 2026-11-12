package org.web.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web.springboot.model.User;
import org.web.springboot.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private final UserRepository repo;

  public UserService (UserRepository repo) {
    this.repo = repo;
  }

  public User registerUser (User user) {
    return repo.save(user);
  }

  public List<User> getUsers () {
    return repo.findAll();
  }

  public void setUsers (List<User> products) {
    // Do something
  }

}
