package org.web.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.web.springboot.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
