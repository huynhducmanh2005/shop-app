package com.project.shopapp.Service.Impl;

import java.util.List;

import com.project.shopapp.DTO.CategoryDTO;
import com.project.shopapp.Model.Category;

public interface ICategoryService {
    List<Category> getAllCategory();

    Category createCategory(CategoryDTO categoryDTO);

    Category getByCategoryId(long id) throws Exception;

    void deleteCategory(long id) throws Exception;

    Category updateCategory(CategoryDTO categoryDTO, long id) throws Exception;
}
