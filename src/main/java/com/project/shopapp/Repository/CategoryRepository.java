package com.project.shopapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shopapp.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
