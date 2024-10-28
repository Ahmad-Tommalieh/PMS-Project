package com.springmvcproject.productmanagementsystem.repository;

import com.springmvcproject.productmanagementsystem.modle.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

}
