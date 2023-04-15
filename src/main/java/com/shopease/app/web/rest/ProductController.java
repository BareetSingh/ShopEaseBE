package com.shopease.app.web.rest;


import com.shopease.app.domain.values.ProductInfo;
import com.shopease.app.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductInfo> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{guid}")
    public ProductInfo getProduct(@PathVariable String guid) {
        return productService.getProduct(guid);
    }

    @PostMapping
    public ProductInfo addProduct(@RequestBody ProductInfo productInfo) {
        return this.productService.addProduct(productInfo);
    }

    @PutMapping("/{guid}")
    public ProductInfo updateProduct(@PathVariable String guid, @RequestBody ProductInfo productInfo) {
        return this.productService.updateProduct(guid, productInfo);
    }

    @DeleteMapping("/{guid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String guid) {
        this.productService.deleteProduct(guid);
    }
}
