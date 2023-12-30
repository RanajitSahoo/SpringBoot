package com.jsp.bootdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.bootdemo.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
