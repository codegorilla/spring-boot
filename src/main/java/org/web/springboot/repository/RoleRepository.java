package org.web.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.web.springboot.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {}
