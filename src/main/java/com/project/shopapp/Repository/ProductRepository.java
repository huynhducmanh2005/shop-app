package com.project.shopapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shopapp.Model.Product;
import com.project.shopapp.Model.ProductImage;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
