package com.shopease.app.services;

import com.shopease.app.domain.entities.Product;
import com.shopease.app.domain.values.ProductInfo;
import com.shopease.app.repositories.ProductRepository;
import com.shopease.app.services.mappers.ProductMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductInfo> getProducts() {
        return this.productRepository.findAll()
                .stream().map(ProductMapper.INSTANCE::toProductInfo)
                .collect(Collectors.toList());
    }

    public ProductInfo getProduct(String guid) {
        return this.productRepository.findByGuid(guid)
                .map(ProductMapper.INSTANCE::toProductInfo)
                .orElseThrow();
    }

    public ProductInfo addProduct(ProductInfo productInfo) {
        Product product = this.productRepository.save(ProductMapper.INSTANCE.toProduct(productInfo));
        return ProductMapper.INSTANCE.toProductInfo(product);
    }

    public ProductInfo updateProduct(String guid, ProductInfo productInfo) {
        return this.productRepository.findByGuid(guid)
                .map(product -> {
                            ProductMapper.INSTANCE.toExistingProduct(productInfo, product);
                            this.productRepository.save(product);
                            return ProductMapper.INSTANCE.toProductInfo(product);
                        }
                ).orElseThrow();
    }

    public void deleteProduct(@NonNull final String guid) {
        this.productRepository.findByGuid(guid)
                .ifPresentOrElse(this.productRepository::delete, () -> {
                    try {
                        throw new FileNotFoundException(String.format("No Product found with ID %s", guid));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
