package org.web.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.web.springboot.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
