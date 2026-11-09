package org.web.springboot.service;

import org.springframework.boot.convert.DurationFormat;
import org.springframework.stereotype.Service;
import org.web.springboot.model.Product;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

  private List<Product> products = Arrays.asList(
    new Product("Dev"),
    new Product("Test"),
    new Product("Stage"),
    new Product("Prod")
  );

  public List<Product> getProducts () {
    return products;
  }

  public void setProducts (List<Product> products) {
    // Do something
  }

}
