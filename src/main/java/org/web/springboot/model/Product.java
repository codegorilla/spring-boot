package org.web.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

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

  public Long getId () {
    return id;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public String getShortName () {
    return shortName;
  }

  public void setShortName (String shortName) {
    this.shortName = shortName;
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
