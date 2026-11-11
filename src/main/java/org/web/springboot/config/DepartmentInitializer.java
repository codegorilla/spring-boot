package org.web.springboot.config;

import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.web.springboot.model.Department;
import org.web.springboot.repository.DepartmentRepo;

@Configuration
public class DepartmentInitializer {

  @Bean
  CommandLineRunner initializeDepartments(DepartmentRepo repository) {

    var args = new CommandLineRunner() {
      @Override
      public void run (String... args) throws Exception {
        if (repository.count() == 0) {
          String[] departments = {
            "Accounting",
            "Customer Service",
            "Engineering",
            "Finance",
            "Human Resources",
            "Information Technology (IT)",
            "Legal",
            "Marketing",
            "Sales"
          };
          for (String name : departments)
            repository.save(new Department(name));
        }
      }
    };

    return args;
  }
}
