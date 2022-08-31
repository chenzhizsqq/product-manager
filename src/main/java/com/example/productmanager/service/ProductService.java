package com.example.productmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.productmanager.entity.Product;
import com.example.productmanager.repository.ProductRepository;

@Service    //对一个或多个DAO进行的再次封装。所有的内部的业务逻辑都会放在这里处理，比如用户的增删改查。
@Transactional  //@Transactional 检查空指针为主。注解默认会回滚运行时异常及其子类。@Transactional 注解只能应用到 public 方法或者类上才有效
public class ProductService {

    @Autowired  //@Autowired后，Spring也会自动生成 getter()和setter()方法。
    private ProductRepository repo;

    public List<Product> listAll() {
        return repo.findAll();  //由于repo是通过JpaRepository生成的，所以就会自动有这个函数
    }

    public void save(Product product) {
        repo.save(product);     //由于repo是通过JpaRepository生成的，所以就会自动有这个函数
    }

    public Product get(long id) {
        return repo.findById(id).get();   //由于repo是通过JpaRepository生成的，所以就会自动有这个函数
    }

    public void delete(long id) {
        repo.deleteById(id);    //由于repo是通过JpaRepository生成的，所以就会自动有这个函数
    }
}