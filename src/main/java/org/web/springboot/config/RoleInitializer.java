package org.web.springboot.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.web.springboot.model.Role;
import org.web.springboot.repository.RoleRepository;

@Configuration
public class RoleInitializer {

  @Bean
  CommandLineRunner initializeRoles (RoleRepository repository) {

    var args = new CommandLineRunner() {
      @Override
      public void run (String... args) throws Exception {
        if (repository.count() == 0) {
          String[] roles = {
            "Developer",
            "Financial Manager",
            "Product Owner",
            "Security Analyst"
          };
          for (var name : roles)
            repository.save(new Role(name));
        }
      }
    };

    return args;
  }
}
