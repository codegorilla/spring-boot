package org.web.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// This could potentially just be an enum rather than a whole
// separate database table. But if it needs to be updated, that
// would entail re-deploying the entire application.

@Entity
@Table(name = "departments")
@Getter
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(nullable = false)
  private String name;

  public Department () {}

  public Department (Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Department (String name) {
    this.name = name;
  }

  @Override
  public String toString () {
    return "Department(%d, %s)".formatted(id, name);
  }

}
