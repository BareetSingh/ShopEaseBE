package com.shopease.app.domain.values;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shopease.app.utils.ProductCategory;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = {"guid"}, allowGetters = true)
public class ProductInfo {

    private String guid;

    @NotNull(message = "Name is required")
    private String productName;

    @NotNull(message = "Award category is required")
    private ProductCategory productCategory;

    private BigDecimal price;

    private String description;

    private String brand;

    private String mainImageUrl;


}
