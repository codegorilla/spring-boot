package org.web.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// This could potentially just be an enum rather than a whole
// separate database table. But if it needs to be updated, that
// would entail re-deploying the entire application.

@Entity
@Table(name = "departments")
@Getter
@NoArgsConstructor
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(nullable = false, unique = true)
  private String name;

  public Department (String name) {
    this.name = name;
  }

  @Override
  public String toString () {
    return "Department{id=%d, name=%s}".formatted(id, name);
  }

}
