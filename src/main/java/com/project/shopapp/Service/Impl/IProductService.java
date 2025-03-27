package com.project.shopapp.Service.Impl;

import java.util.List;

import com.project.shopapp.DTO.ProductDTO;
import com.project.shopapp.Model.Product;

public interface IProductService {
    List<Product> getAllProduct();

    Product getByProductId(long id) throws Exception;

    void deleteProduct(long id) throws Exception;

    Product createProduct(ProductDTO productDTO) throws Exception;

    Product updateProduct(ProductDTO productDTO, long id) throws Exception;

}
