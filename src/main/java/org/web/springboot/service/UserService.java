package org.web.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web.springboot.model.Product;
import org.web.springboot.model.User;
import org.web.springboot.repository.UserRepo;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepo repo;

  public List<User> getUsers () {
    return repo.findAll();
  }

  public void setUsers (List<User> products) {
    // Do something
  }

}
