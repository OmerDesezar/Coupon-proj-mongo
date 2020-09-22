package com.omer.couponprojmongo.services;

import com.omer.couponprojmongo.model.Category;
import com.omer.couponprojmongo.model.CategoryType;
import com.omer.couponprojmongo.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository repository;

    private Optional<Category> findByType(CategoryType type) {
        return repository.findByType(type);
    }

    public Category createOrGet(CategoryType type) {
        return findByType(type).orElseGet(() -> repository.save(new Category(type)));
    }
}

