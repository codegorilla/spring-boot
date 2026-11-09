package org.web.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.security.core.parameters.P;

@Entity
public class Product {

  @Id
  private int id;
  private String name;

  public Product() {}

  public Product(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Product (String name) {
    this.name = name;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  @Override
  public String toString () {
    return "Product(%d, %s)".formatted(id, name);
  }
}
