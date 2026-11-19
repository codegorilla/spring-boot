package org.web.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.web.springboot.service.ProductService;

@Controller
public class ProductController {

  private final ProductService productService;

  public ProductController (ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products")
  public String getProducts (Model model) {
    model.addAttribute("users", productService.getProducts());
    return "products";
//    return "Here are your products!\n" +
//      productService.getProducts().stream()
//        .filter(product -> product.getId() > 1)
//        .toList();
  }

  @GetMapping("/products/{id}")
  public String getProduct (@PathVariable Long id, Model model) {
//    var product = productService.getProduct(id);
    return "products/details";
  }

}
