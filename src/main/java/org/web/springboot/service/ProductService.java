package org.web.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.DurationFormat;
import org.springframework.stereotype.Service;
import org.web.springboot.model.Product;
import org.web.springboot.repository.ProductRepo;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepo repo;

//  private List<Product> products = Arrays.asList(
//    new Product("Dev"),
//    new Product("Test"),
//    new Product("Stage"),
//    new Product("Prod")
//  );

  public List<Product> getProducts () {
    return repo.findAll();
  }

  public void setProducts (List<Product> products) {
    // Do something
  }

}
