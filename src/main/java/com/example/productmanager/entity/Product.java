package com.example.productmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data   //对应lombok库，自动实现get、set、equals、hashCode、canEqual、toString方法
@Entity //对应Spring Data JPA库，自动实现数据class的对应，get...() 和 set...() 的方法，自动生成。
public class Product {
    private Long id;
    private String name;
    private String brand;
    private String madein;
    private float price;

    public Product() {
    }

    @Id ////对应Spring Data JPA库，注解表名是表的自增主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
}