package com.omer.couponprojmongo.repositories;

import com.omer.couponprojmongo.model.Category;
import com.omer.couponprojmongo.model.CategoryType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    Optional<Category> findByType(CategoryType type);

}