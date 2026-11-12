package org.web.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web.springboot.model.Product;
import org.web.springboot.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repo;

  public List<Product> getProducts () {
    return repo.findAll();
  }

  public void setProducts (List<Product> products) {
    // Do something
  }

}
