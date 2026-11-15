package org.web.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
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
    return repository.findAll(Sort.by("name"));
  }

//  public List<Department> findAllSorted () {
//    return repository.findAll(Sort.by("name"));
//  }

  // CAI had this, not sure if we need it
//  public Department getById (Long id) {
//    return repository.findById(id)
//      .orElseThrow(() -> new IllegalArgumentException("Unknown department: " + id));
//  }

}


