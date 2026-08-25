package com.product.producku.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.producku.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
