package com.project.shopapp.Service.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.project.shopapp.DTO.ProductDTO;
import com.project.shopapp.Model.Product;
import com.project.shopapp.Repository.CategoryRepository;
import com.project.shopapp.Repository.ProductRepository;
import com.project.shopapp.Service.Impl.IProductService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getByProductId(long id) throws Exception {
        try {
            return productRepository.findById(id).orElseThrow(() -> new Exception("Mã sản phẩm này không tồn tại"));

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void deleteProduct(long id) throws Exception {
        try {
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new Exception("Không tìm thấy mã sản phẩm này để xóa"));
            productRepository.delete(product);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Product createProduct(ProductDTO productDTO) throws Exception {
        try {
            categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new Exception("Mã loại hàng này không tồn tại"));
            Product product = Product.builder()
                    .name(productDTO.getName())
                    .thumbnail(productDTO.getThumbnail())
                    .price(productDTO.getPrice())
                    .description(productDTO.getDescription())
                    .category(categoryRepository.findById(productDTO.getCategoryId())
                            .orElseThrow(() -> new Exception("Mã loại hàng này không tồn tại")))
                    .build();
            return productRepository.save(product);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Product updateProduct(ProductDTO productDTO, long id) throws Exception {
        try {
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new Exception("Mã sản phẩm này không tồn tại để sửa"));
            categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new Exception("Mã loại hàng này không tồn tại "));
            product.setName(productDTO.getName());
            product.setThumbnail(productDTO.getThumbnail());
            product.setCategory(categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new Exception("Mã loại hàng này không tồn tại")));
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            return productRepository.save(product);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void fakerProduct() throws Exception {
        try {

            Faker faker = new Faker();
            for (int i = 0; i < 20; i++) {
                Product product = Product.builder()
                        .name(faker.commerce().productName())
                        .price(faker.number().numberBetween(1, 10) * 10000)
                        .thumbnail(null)
                        .category(categoryRepository.findById(Long.valueOf(faker.number().numberBetween(4, 9)))
                                .orElseThrow(() -> new Exception("Loại hàng này không tồn tại")))
                        .description(faker.lorem().sentence())
                        .build();
                productRepository.save(product);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
