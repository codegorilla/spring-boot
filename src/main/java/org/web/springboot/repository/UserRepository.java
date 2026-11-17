package org.web.springboot.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.web.springboot.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @EntityGraph(attributePaths = {"userProfile", "userProfile.department"})
  List<User> findAllWithProfileBy();

  @EntityGraph(attributePaths = {"userProfile", "userProfile.department"})
  Optional<User> findWithProfileById(Long id);
}
