package com.project.shopapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shopapp.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
