package com.project.shopapp.Service.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopapp.DTO.CategoryDTO;
import com.project.shopapp.Model.Category;
import com.project.shopapp.Repository.CategoryRepository;
import com.project.shopapp.Service.Impl.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = Category.builder()
                .name(categoryDTO.getName())
                .build();
        return categoryRepository.save(category);
    }

    @Override
    public Category getByCategoryId(long id) throws Exception {
        try {
            return categoryRepository.findById(id).orElseThrow(() -> new Exception("Không tìm thấy mã loại hàng này"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(long id) throws Exception {
        try {
            Category category = categoryRepository.findById(id)
                    .orElseThrow(() -> new Exception("Mã loại hàng này không tồn tại để xóa "));
            categoryRepository.delete(category);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Category updateCategory(CategoryDTO categoryDTO, long id) throws Exception {
        try {
            Category category = categoryRepository.findById(id)
                    .orElseThrow(() -> new Exception("Mã loại hàng này không tồn tại để sửa"));
            category.setName(categoryDTO.getName());
            return categoryRepository.save(category);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
