package com.omer.couponprojmongo.repositories;

import com.omer.couponprojmongo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    boolean existsByEmailAndPassword(String email, String password);
    Optional<Customer> findByEmail(String email);
    Boolean existsByEmail(String email);
    Optional<Customer> findByFirstNameAndLastName(String firstName, String lastName);

}
