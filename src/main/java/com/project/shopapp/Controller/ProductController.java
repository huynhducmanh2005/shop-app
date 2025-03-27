package com.project.shopapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.shopapp.DTO.ProductDTO;
import com.project.shopapp.Model.Product;
import com.project.shopapp.Service.Services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> getAllProduct() {

        List<Product> listProducts = productService.getAllProduct();
        return ResponseEntity.ok(listProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByProductId(@PathVariable long id) {
        try {
            Product product = productService.getByProductId(id);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok(String.format("Đã xóa thành công sản phẩm có id = %d", id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createProducts(@Valid @RequestBody ProductDTO productDTO) {
        try {
            Product product = productService.createProduct(productDTO);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProducts(@Valid @PathVariable long id, @RequestBody ProductDTO productDTO) {
        try {
            Product product = productService.updateProduct(productDTO, id);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
