package com.springmvcproject.productmanagementsystem.controller;

import com.springmvcproject.productmanagementsystem.modle.entity.Product;
import com.springmvcproject.productmanagementsystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("get-product-by-id/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("update/{id}")
    public Product updateProduct(@PathVariable Long id , @RequestBody Product productDetails){
        return productService.updateProduct(id, productDetails);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
