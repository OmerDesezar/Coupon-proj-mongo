package com.omer.couponprojmongo.services;

import com.omer.couponprojmongo.exceptions.AlreadyExistsException;
import com.omer.couponprojmongo.exceptions.NotExistsException;
import com.omer.couponprojmongo.model.Customer;
import com.omer.couponprojmongo.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class CustomerService implements EntityService<Customer> {

    private CustomerRepository repository;

    public boolean isCustomerExists(String email, String password) {
        return repository.existsByEmailAndPassword(email, password);
    }

    public Optional<Customer> findByCustomerEmail(String email){
        return repository.findByEmail(email);
    }

    @Override
    public Customer save(Customer customer) throws AlreadyExistsException {
        if (repository.existsByEmail(customer.getEmail())){
            throw new AlreadyExistsException("A customer with the email " + customer.getEmail() + " already exists");
        }
        return repository.save(customer);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Optional<Customer> findByEmail(String email){
        return repository.findByEmail(email);
    }

    public String getIdByEmail(String email)throws NotExistsException{
        return repository.findByEmail(email)
                .map(Customer::getId)
                .orElseThrow(()->
                        new NotExistsException("A company with the email " +
                                email + " doesnt exist"));
    }

    public String getIdByName(String firstName, String lastName)throws NotExistsException{
        return repository.findByFirstNameAndLastName(firstName, lastName)
                .map(Customer::getId)
                .orElseThrow(()->
                        new NotExistsException("A company with the name " +
                                firstName + " " + lastName + " doesnt exist"));
    }

    public Customer updateCustomer(Function<Customer, Customer> mapper, String id) throws NotExistsException {
        return findById(id)
                .map(byId -> mapper
                        .andThen(customer -> {
                            try {
                               return save(customer);
                            } catch (AlreadyExistsException e) {
                                e.printStackTrace();
                                System.out.println("**DID NOT UPDATE**");
                            }
                            return customer;
                        })
                        .apply(byId))
                .orElseThrow(() -> new NotExistsException(
                        "A customer with the ID " + id + "doesnt exist"));
    }

    public Customer deleteCustomer(String customerId) throws NotExistsException {
        return findById(customerId)
                .map(customer -> {
                    repository.delete(customer);
                    return customer;
                }).orElseThrow(() -> new NotExistsException("A customer with the ID " + customerId + " doesnt exist"));
    }
}

