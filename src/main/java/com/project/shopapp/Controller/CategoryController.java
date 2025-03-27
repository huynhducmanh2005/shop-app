package com.project.shopapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.project.shopapp.DTO.CategoryDTO;
import com.project.shopapp.Model.Category;
import com.project.shopapp.Service.Services.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")

    public ResponseEntity<?> getAllCategory() {
        List<Category> listCategory = categoryService.getAllCategory();
        return ResponseEntity.ok(listCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByCategoryId(@PathVariable long id) {
        try {
            Category category = categoryService.getByCategoryId(id);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        try {
            Category category = categoryService.createCategory(categoryDTO);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable long id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.ok(String.format("Đã xóa thành công loại hàng có id = %d ", id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@Valid @PathVariable long id, @RequestBody CategoryDTO categoryDTO) {
        try {
            Category category = categoryService.updateCategory(categoryDTO, id);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
