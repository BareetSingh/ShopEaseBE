package com.shopease.app.services.mappers;

import com.shopease.app.domain.entities.Product;
import com.shopease.app.domain.values.ProductInfo;

public class ProductMapper {

    public static Product toProduct(ProductInfo productInfo) {
        Product product = new Product();
        product.setProductName(productInfo.getProductName());
        product.setProductCategory(productInfo.getProductCategory());
        product.setPrice(productInfo.getPrice());
        product.setBrand(productInfo.getBrand());
        product.setDescription(productInfo.getDescription());
        product.setMainImageUrl(productInfo.getMainImageUrl());
        return product;
    }

    public static void toExistingProduct(ProductInfo productInfo, Product product) {

        if (productInfo.getProductName() != null) {
            product.setProductName(productInfo.getProductName());
        }
        if (productInfo.getProductCategory() != null) {
            product.setProductCategory(productInfo.getProductCategory());
        }
        if (productInfo.getPrice() != null) {
            product.setPrice(productInfo.getPrice());
        }
        if (productInfo.getDescription() != null) {
            product.setDescription(productInfo.getDescription());
        }
        if (productInfo.getBrand() != null) {
            product.setBrand(productInfo.getBrand());
        }
        if (productInfo.getMainImageUrl() != null) {
            product.setMainImageUrl(productInfo.getMainImageUrl());
        }
    }

    public static ProductInfo toProductInfo(Product product) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setGuid(product.getGuid());
        productInfo.setProductName(product.getProductName());
        productInfo.setProductCategory(product.getProductCategory());
        productInfo.setPrice(product.getPrice());
        productInfo.setBrand(product.getBrand());
        productInfo.setMainImageUrl(product.getMainImageUrl());
        return productInfo;
    }
}
