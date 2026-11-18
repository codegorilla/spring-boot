package org.web.springboot.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web.springboot.model.User;
import org.web.springboot.model.UserProfile;
import org.web.springboot.model.Department;
import org.web.springboot.repository.DepartmentRepository;
import org.web.springboot.repository.UserRepository;

@Configuration
public class UserInitializer {

  @Bean
  CommandLineRunner initializeUsers (UserRepository repository, DepartmentRepository departmentRepository) {

    var args = new CommandLineRunner() {
      @Override
      public void run (String... args) throws Exception {
        if (repository.count() == 0) {

          Department d1 = new Department();
          d1.setName("Tinkering");
          d1 = departmentRepository.save(d1);

          Department d2 = new Department();
          d2.setName("Dabbling");
          d2 = departmentRepository.save(d2);

          var p = new UserProfile();
          p.setOrganization("Usoft Systems");
          p.setDepartment(d1);
          p.setJobTitle("Engineer");

          var u = new User();
          u.setFirstName("James");
          u.setLastName("Smith");
          u.setEmailAddress("jsmith@usoft.com");
          u.setUserProfile(p);
          repository.save(u);
        }
      }
    };

    return args;
  }
}
