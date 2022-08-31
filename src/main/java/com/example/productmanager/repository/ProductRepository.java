package com.example.productmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productmanager.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}