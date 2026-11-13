package org.web.springboot.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.web.springboot.model.Department;
import org.web.springboot.repository.DepartmentRepository;

@Configuration
public class DepartmentInitializer {

  @Bean
  CommandLineRunner initializeDepartments (DepartmentRepository repository) {

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
            "Sales",
            "Other"
          };
          for (var name : departments)
            repository.save(new Department(name));
        }
      }
    };

    return args;
  }
}
