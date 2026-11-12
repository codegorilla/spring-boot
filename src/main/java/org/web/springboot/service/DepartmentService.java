package org.web.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web.springboot.model.Department;
import org.web.springboot.repository.DepartmentRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentService {

  private final DepartmentRepository repository;

  public DepartmentService (DepartmentRepository repository) {
    this.repository = repository;
  }

  public List<Department> getDepartments () {
    return repository.findAll();
  }

}
