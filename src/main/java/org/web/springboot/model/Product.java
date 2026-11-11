package org.web.springboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(nullable = false)
  private String name;

  @Setter
  @Column(length = 32)
  private String shortName;

  @Enumerated(EnumType.STRING)
  @Column(name = "product_type", nullable = false, length = 32)
  private ProductType type;

  public Product () {}

  public Product (Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Product (String name) {
    this.name = name;
  }

  public ProductType getProductType () {
    return type;
  }

  public void setProductType (ProductType type) {
    this.type = type;
  }

  @Override
  public String toString () {
    return "Product(%d, %s)".formatted(id, name);
  }
}
