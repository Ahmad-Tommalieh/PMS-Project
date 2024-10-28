package com.springmvcproject.productmanagementsystem.service;

import com.springmvcproject.productmanagementsystem.exception.ProductNotFoundException;
import com.springmvcproject.productmanagementsystem.modle.entity.Product;
import com.springmvcproject.productmanagementsystem.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getProductById(Long id){
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
    public Product createProduct(Product product){
        return productRepo.save(product);
    }

    public Product updateProduct(Long id , Product productDetails){
        Product product= getProductById(id);
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        return productRepo.save(product);
    }

    public void deleteProduct(Long id){
        Product product = getProductById(id);
        productRepo.delete(product);
    }
}
