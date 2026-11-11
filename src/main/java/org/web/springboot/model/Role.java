package org.web.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// The permissions that roles impart are coded into the business
// logic of the application. Generally speaking, a given role will
// map to a group in the identity store. For products of type
// "infrastructure", they may map to cloud roles; whereas for products
// of type "platform", they may map to kubernetes groups.

@Entity
@Table(name = "roles")
@Getter
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(nullable = false, unique = true)
  private String name;

}
