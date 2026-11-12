package org.web.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Setter
  @Column(nullable = false)
  private String firstName;

  @Setter
  @Column(nullable = false)
  private String lastName;

  @Setter
  @Column(nullable = false, unique = true, length = 256)
  private String emailAddress;

  @Setter
  @Column(nullable = false, length = 256)
  private String organization;

//  @Setter
//  @ManyToOne
//  @JoinColumn(name = "department_id", nullable = false)
//  private Department department;
//
//  @ManyToMany(fetch = FetchType.EAGER)
//  @JoinTable(
//    name = "user_roles",
//    joinColumns = @JoinColumn(name = "user_id"),
//    inverseJoinColumns = @JoinColumn(name = "role_id")
//  )
//  private final Set<Role> roles = new HashSet<>();


  @Override
  public String toString () {
    return "User(%d, %s, %s)".formatted(id, firstName, lastName); //, department);
  }

}
