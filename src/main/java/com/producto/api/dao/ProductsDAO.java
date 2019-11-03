package com.producto.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.producto.api.entity.Product;

public interface ProductsDAO extends JpaRepository<Product,Long>{
 
}
