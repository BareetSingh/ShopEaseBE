package com.shopease.app.domain.entities;

import com.shopease.app.utils.ProductCategory;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Table(name = "product")
@Entity
public class Product {
    @Id
    @Column(unique = true, nullable = false, updatable = false, length = 36)
    protected String guid = UUID.randomUUID().toString();

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    private String productName;

    private BigDecimal price;

    private String description;

    private String brand;

    private String mainImageUrl;
}
