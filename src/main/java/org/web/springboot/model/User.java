package org.web.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(nullable = false, unique = true)
  private String username;

  @Setter
  @Column(nullable = false)
  private String firstName;

  @Setter
  @Column(nullable = false)
  private String lastName;

  @Setter
  @Column(nullable = false, unique = true, length = 256)
  private String emailAddress;

}
