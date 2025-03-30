package com.project.shopapp.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.shopapp.DTO.ProductDTO;
import com.project.shopapp.Model.Product;
import com.project.shopapp.Model.ProductImage;
import com.project.shopapp.Repository.ProductImageRepository;
import com.project.shopapp.Response.ProductResponse;
import com.project.shopapp.Service.Services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductImageRepository productImageRepository;

    private final Path rootLocation = Paths.get("upload");

    @GetMapping("/")
    public ResponseEntity<?> getAllProduct() {

        List<Product> listProducts = productService.getAllProduct();
        return ResponseEntity.ok(listProducts.stream().map(ProductResponse::fromProduct).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByProductId(@PathVariable long id) {
        try {
            Product product = productService.getByProductId(id);
            return ResponseEntity.ok(ProductResponse.fromProduct(product));
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

    @PostMapping("/generate-fake-data")
    public ResponseEntity<?> fakeDataProDuct() {
        try {
            productService.fakerProduct();
            return ResponseEntity.ok("Tạo thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping(value = "/{id}/images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadProductImage(
            @PathVariable long id,
            @RequestParam("file") MultipartFile file) {
        try {
            Product product = productService.getByProductId(id);

            String originalFileName = file.getOriginalFilename();
            String extention = originalFileName.substring(originalFileName.lastIndexOf("."));
            String newFileName = UUID.randomUUID().toString() + extention;

            Path destinationFile = rootLocation.resolve(Paths.get(newFileName)).normalize().toAbsolutePath();

            try (var inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
            //////////////////////////////////////////////////////////////////
            ProductImage productImage = new ProductImage();
            productImage.setProduct(product);
            productImage.setImageUrl("/upload/" + newFileName);

            productImageRepository.save(productImage);

            return ResponseEntity.ok(productImage);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}/images")
    public ResponseEntity<?> findImages(@PathVariable long id) {
        try {
            List<ProductImage> listprProductImages = productImageRepository.findByProductId(id);
            return ResponseEntity.ok(listprProductImages);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
