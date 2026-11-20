package org.web.springboot.dto;

import jakarta.validation.constraints.NotBlank;
import org.web.springboot.model.ProductType;
import lombok.Data;

@Data
public class CreateProductForm {

  @NotBlank
  private String name;

  @NotBlank
  private String shortName;

  @NotBlank
  private ProductType type;
}
