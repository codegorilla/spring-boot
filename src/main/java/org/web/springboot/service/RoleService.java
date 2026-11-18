package org.web.springboot.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.web.springboot.model.Role;
import org.web.springboot.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {

  private final RoleRepository repository;

  public RoleService (RoleRepository repository) {
    this.repository = repository;
  }

  public List<Role> getRoles () {
    return repository.findAll(Sort.by("name"));
  }

}
