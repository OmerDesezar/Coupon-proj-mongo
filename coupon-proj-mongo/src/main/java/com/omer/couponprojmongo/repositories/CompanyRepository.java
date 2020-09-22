package com.omer.couponprojmongo.repositories;

import com.omer.couponprojmongo.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {

    boolean existsByEmailAndPassword(String email, String password);
    Optional<Company> findByEmail(String email);
    Optional<Company> findByName(String name);
    Boolean existsByName(String name);

}
