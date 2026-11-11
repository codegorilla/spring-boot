package org.web.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web.springboot.model.Department;
import org.web.springboot.model.Product;
import org.web.springboot.repository.DepartmentRepo;

import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepo repo;

  private final List<Department> departments = Arrays.asList(
    new Department("Customer Service"),
    new Department("Finance"),
    new Department("Human Resources"),
    new Department("IT"),
    new Department("Legal"),
    new Department("Marketing"),
    new Department("Research"),
    new Department("Sales")
  );
  
  public List<Department> getDepartments () {
    return repo.findAll();
  }

  public void setDepartments (List<Department> departments) {
    // Do something
  }

}
