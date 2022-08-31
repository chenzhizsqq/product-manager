package com.example.productmanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.productmanager.entity.Product;

/*
因为class Product中设定了getId()为主键，而id是Long形，所以这里<Product, Long>
JpaRepository<Product, Long> 的意义是，用JpaRepository对应Product，主键是Long形
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}